package com.crazyang.dao;


import com.crazyang.bo.GoodsBo;
import com.crazyang.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName GoodsMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 下午7:29.
 */
@Mapper
public interface GoodsMapper {

    @Select("Select *  from goods left join seckill_goods sg on sg.goods_id = goods.id")
    @Results({
            @Result(property = "seckillPrice", column = "seckill_rice"),
            @Result(property = "stockCount", column = "stock_count"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "id", column = "id"),
            @Result(property = "goodsName", column = "goods_name"),
            @Result(property = "goodsTitle", column = "goods_title"),
            @Result(property = "goodsImg", column = "goods_img"),
            @Result(property = "goodsPrice", column = "goods_price"),
            @Result(property = "goodsStock", column = "goods_stock"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateDate", column = "update_date"),
            @Result(property = "goodsDetail", column = "goods_detail"),
    })
    List<GoodsBo> selectAllGoods ();

    @Select("Select * from goods left join seckill_goods sg on sg.goods_id = goods.id where goods.id=#{goodsId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "seckillPrice", column = "seckill_rice"),
            @Result(property = "stockCount", column = "stock_count"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "goodsName", column = "goods_name"),
            @Result(property = "goodsTitle", column = "goods_title"),
            @Result(property = "goodsImg", column = "goods_img"),
            @Result(property = "goodsPrice", column = "goods_price"),
            @Result(property = "goodsStock", column = "goods_stock"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateDate", column = "update_date"),
            @Result(property = "goodsDetail", column = "goods_detail"),
    })
    GoodsBo selectGoodsById(long goodsId);


    @Insert("insert into goods(goods_name,goods_title,goods_img,goods_detail,goods_price,goods_stock,create_date)" +
            "values(#{goodsName},#{goodsTitle},#{goodsImg},#{goodsDetail},#{goodsPrice},#{goodsStock},#{createDate})")
    int insertGoods(Goods goods);

}
