package com.crazyang.core.aop.log;

import com.crazyang.entity.OperationLog;
import com.crazyang.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName LogAspect
 * @Description: 切面日志配置
 * @Author zhouyang
 * @Date 2019/4/11 上午11:31.
 */

@Aspect
@Component
public class LogAspect {
    private final static Logger log = org.slf4j.LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private LogService logService;

    //表示匹配带有自定义注解的方法
    @Pointcut("@annotation(com.crazyang.core.aop.log.LogConfig)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();

        try {
            log.info("我在目标方法之前执行！");
            result = point.proceed();
            long endTime = System.currentTimeMillis();
            insertLog(point, endTime - beginTime);
        } catch (Throwable e) {
            // TODO Auto-generated catch block
        }
        return result;
    }

    private void insertLog(ProceedingJoinPoint point, long time) throws IOException {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        OperationLog sys_log = new OperationLog();

        LogConfig userAction = method.getAnnotation(LogConfig.class);
        if (userAction != null) {
            // 注解上的描述
            sys_log.setUserAction(userAction.value());
        }

        // 请求的类名
        String className = point.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = signature.getName();
        // 请求的方法参数值
        String args = Arrays.toString(point.getArgs());

        //获取用户ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String userIp = getIpAddress(request);


        //从session中获取当前登陆人id
//		Long useride = (Long)SecurityUtils.getSubject().getSession().getAttribute("userid");

        int userId = 101;//应该从session中获取当前登录人的id，这里简单模拟下

        sys_log.setUserId(userId);

        sys_log.setUserIp(userIp);

        sys_log.setCreateTime(new java.sql.Timestamp(new Date().getTime()));

        log.info("当前登陆人：{},类名:{},方法名:{},参数：{},用户ip:{},执行时间：{}", userId, className, methodName, args, userIp, time);

        logService.insertLog(sys_log);
    }


    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     * @throws IOException
     */
    public final static String getIpAddress(HttpServletRequest request)
            throws IOException {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
