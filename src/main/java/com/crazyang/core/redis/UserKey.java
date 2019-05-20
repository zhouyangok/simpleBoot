package com.crazyang.core.redis;

/**
 * @ClassName UserKey
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/20 上午11:28.
 */

public class UserKey extends BasePrefix{

    private UserKey(String prefix) {
        super(prefix);
    }
    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
