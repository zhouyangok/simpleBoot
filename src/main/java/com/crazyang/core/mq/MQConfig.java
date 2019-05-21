package com.crazyang.core.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MQConfig
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午9:11.
 */
@Configuration
public class MQConfig {

    public static final String MIAOSHA_QUEUE = "miaosha.queue";
    public static final String FAHUO_QUEUE = "fahuo.queue";


    @Bean
    public MessageConverter getMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public Queue queue() {
        return new Queue(MIAOSHA_QUEUE, true);
    }

}
