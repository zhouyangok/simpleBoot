package com.crazyang.core.mq;

import com.crazyang.entity.User;

/**
 * @ClassName MiaoShaMessage
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午9:16.
 */

public class MiaoShaMessage {
    private User user;
    private long userId;
    private long goodsId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }
}
