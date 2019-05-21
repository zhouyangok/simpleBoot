package com.crazyang.core.mq;

import com.crazyang.core.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MQSender
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午9:12.
 */

@Service
public class MQSender {

    private static Logger logger = LoggerFactory.getLogger(MQSender.class);

    @Autowired
    AmqpTemplate amqpTemplate ;

    public void sendMiaoShaMessage(MiaoShaMessage message){
        String msg = RedisService.beanToString(message);
        String mes= "hllo";
        logger.info("rabbitmq发送消息:"+msg);
        amqpTemplate.convertAndSend(MQConfig.MIAOSHA_QUEUE,msg);
    }
}
