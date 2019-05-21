package com.crazyang.service;

import com.crazyang.entity.MiaoShaOrder;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午11:37.
 */

public interface OrderService {

    MiaoShaOrder getMiaoShaOrderByUserIdAndGoodsId(long userId, long goodsId);

    List getList(long id);

    long addOrder(MiaoShaOrder miaoShaOrder);
}
