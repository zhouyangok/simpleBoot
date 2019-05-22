package com.crazyang.service.impl;

import com.crazyang.bo.GoodsBo;
import com.crazyang.core.exception.GlobalException;
import com.crazyang.dao.GoodsMapper;
import com.crazyang.entity.Goods;
import com.crazyang.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GoodsServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 下午5:35.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsBo> getGoodsList() {
        return goodsMapper.selectAllGoods();
    }

    @Override
    public List<GoodsBo> getSeckillGoodsList() {

//        return goodsMapper.getSeckillGoodsList();
        return null;
    }

    @Override
    public GoodsBo getseckillGoodsBoByGoodsId(long goodsId) {
        return goodsMapper.selectGoodsById(goodsId);
    }

    @Override
    public int reduceStock(long goodsId) {
        return 0;
    }

    @Override
    public int insertGoods(Goods goods) {
        try {
            return goodsMapper.insertGoods(goods);
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }

    }
}
