package com.crazyang.controller;

import com.crazyang.bo.GoodsBo;
import com.crazyang.core.aop.log.LogConfig;
import com.crazyang.core.mq.MQSender;
import com.crazyang.core.mq.MiaoShaMessage;
import com.crazyang.core.redis.RedisService;
import com.crazyang.core.redis.UserKey;
import com.crazyang.core.utils.JwtTokenUtils;
import com.crazyang.entity.MiaoShaOrder;
import com.crazyang.result.CodeMsg;
import com.crazyang.result.Result;
import com.crazyang.service.GoodsService;
import com.crazyang.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName OrderController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午11:13.
 */
@Controller
@RequestMapping("/web/order")
public class OrderController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MQSender mqSender;

    @LogConfig("用户下单")
    @ApiOperation(value = "用户下单")
    @PostMapping("/userOrder")
    @ResponseBody
    public Result userOrder(HttpServletRequest request, @RequestParam("goodsId") long goodsId) {
        //1.获取用户token，并根据token获取用户信息
        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
//        String username = JwtTokenUtils.getUsername(token);
        long userId = 100002;

        //2.判断库存
        GoodsBo goodsBo = goodsService.getseckillGoodsBoByGoodsId(goodsId);
        int stock = goodsBo.getStockCount();
        if (stock < 0) {
            return Result.error(CodeMsg.MIAO_SHA_OVER);
        }
        //3.判断是否已经秒杀
        List list = orderService.getList(goodsId);
        MiaoShaOrder order = orderService.getMiaoShaOrderByUserIdAndGoodsId(userId, goodsId);
        if (order != null) {
            return Result.error(CodeMsg.REPEATE_MIAOSHA);
        }
        //4.入队
        MiaoShaMessage msg = new MiaoShaMessage();
        msg.setGoodsId(goodsId);
        msg.setUserId(userId);
        mqSender.sendMiaoShaMessage(msg);
        return Result.success(0);
    }

    @ResponseBody
    @GetMapping("/list")
    public List getList() {
        long id = 100;
        List list = orderService.getList(id);
        return list;
    }
}
