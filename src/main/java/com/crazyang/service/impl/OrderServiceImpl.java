package com.crazyang.service.impl;

import com.crazyang.dao.OrderMapper;
import com.crazyang.entity.MiaoShaOrder;
import com.crazyang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午11:40.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public MiaoShaOrder getMiaoShaOrderByUserIdAndGoodsId(long userId, long goodsId) {
        return orderMapper.getMiaoShaOrderByUserIdAndGoodsId(userId, goodsId);
    }

    @Override
    public List getList(long id) {
      return   orderMapper.getList(id);
    }
}
