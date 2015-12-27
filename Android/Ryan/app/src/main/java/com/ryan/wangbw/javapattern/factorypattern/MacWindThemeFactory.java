package com.ryan.wangbw.javapattern.factorypattern;

/**
 * @author wangbw
 * @desc mac系统工厂，对应concreteFactory角色，获取mac系统风格的主题
 * @date 2015/10/29.
 */
public class MacWindThemeFactory extends ThemeFactory {
    @Override
    public WindowStyle createWindowStyle() {
        return new MacWindowStyle();
    }
}
