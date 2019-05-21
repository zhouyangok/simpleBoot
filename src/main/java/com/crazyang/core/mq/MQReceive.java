package com.crazyang.core.mq;

import com.crazyang.bo.GoodsBo;
import com.crazyang.core.redis.RedisService;
import com.crazyang.core.utils.SnowFlakeUtils;
import com.crazyang.entity.MiaoShaOrder;
import com.crazyang.entity.User;
import com.crazyang.service.GoodsService;
import com.crazyang.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MQReceive
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午9:18.
 */

@Service
public class MQReceive {

    private static Logger logger = LoggerFactory.getLogger(MQReceive.class);

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;


    @RabbitListener(queues = MQConfig.MIAOSHA_QUEUE)
    public void Receive(String message) {
        logger.info("rabbitmq收到消息：" + message);
        MiaoShaMessage msg = RedisService.stringToBean(message, MiaoShaMessage.class);
        long userId = msg.getUserId();
        long goodsId = msg.getGoodsId();
        GoodsBo goodsBo = goodsService.getseckillGoodsBoByGoodsId(goodsId);
        int stock = goodsBo.getStockCount();
        if (stock < 0) {
            return;
        }
        //减库存 下订单 写入秒杀订单
        MiaoShaOrder miaoShaOrder = new MiaoShaOrder();
        miaoShaOrder.setGoodsId((int) goodsId);
        miaoShaOrder.setUserId((int) userId);
        SnowFlakeUtils snowFlake = new SnowFlakeUtils(2, 3);
        miaoShaOrder.setOrderId((int) snowFlake.nextId());

        orderService.addOrder(miaoShaOrder);
        logger.info("用户" + userId + "秒杀成功！");
    }
}
