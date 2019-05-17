package com.crazyang.core.redis;

/**
 * @ClassName BasePrefix
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 下午5:28.
 */

public abstract class BasePrefix implements KeyPrefix {

    private String prefix;

    public BasePrefix( String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":" + prefix;
    }
}
