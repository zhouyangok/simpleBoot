package com.crazyang.core.redis;

/**
 * @ClassName GoodsKey
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 下午5:28.
 */

public class GoodsKey extends BasePrefix {
    public GoodsKey(String prefix) {
        super(prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey("gl");
    public static GoodsKey getGoodsDetail = new GoodsKey("gd");
    public static GoodsKey getSeckillGoodsStock= new GoodsKey( "gs");
}
