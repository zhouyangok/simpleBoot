package com.crazyang.service;

import com.crazyang.bo.GoodsBo;

import java.util.List;

/**
 * @ClassName GoodsService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 下午5:34.
 */

public interface GoodsService {

    List<GoodsBo> getGoodsList();

    List<GoodsBo> getSeckillGoodsList();

    GoodsBo getseckillGoodsBoByGoodsId(long goodsId);

    int reduceStock(long goodsId);
}
