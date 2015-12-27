package com.ryan.wangbw.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangbw
 * @desc 水果颜色注解
 * @date 2015/11/16.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color{BLUE, RED, GREEN};

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;
}
