package com.crazyang.core.aop.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName LogConfig
 * @Description: 定义一个方法级别的@log注解
 * @Author zhouyang
 * @Date 2019/4/11 上午10:47.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogConfig {
    String value() default "";
}
