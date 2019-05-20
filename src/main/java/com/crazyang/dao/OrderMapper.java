package com.crazyang.dao;

import com.crazyang.entity.MiaoShaOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName OrderMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午11:42.
 */

@Mapper
public interface OrderMapper {

    @Select("Select id,user_id,goods_id,order_id from miaosha_order where user_id=#{userId} and goods_id = #{goodsId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "goodsId", column = "goods_id"),
            @Result(property = "orderId", column = "order_id"),
    })
    MiaoShaOrder getMiaoShaOrderByUserIdAndGoodsId(long userId, long goodsId);

    @Select("Select * from miaosha where id=#{id}")
    List getList(long id);
}
