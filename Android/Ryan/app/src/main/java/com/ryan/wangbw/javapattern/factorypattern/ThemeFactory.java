package com.ryan.wangbw.javapattern.factorypattern;

/**
 * @author wangbw
 * @desc 工厂类，对应Factory角色
 * @date 2015/10/29.
 */
public abstract class ThemeFactory {
    public abstract WindowStyle createWindowStyle();
}
