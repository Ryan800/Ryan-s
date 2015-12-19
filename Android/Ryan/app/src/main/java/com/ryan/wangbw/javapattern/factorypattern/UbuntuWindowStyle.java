package com.ryan.wangbw.javapattern.factorypattern;

/**
 * @author wangbw
 * @desc ubuntu风格窗口，对应concreteProduct角色
 * @date 2015/10/29.
 */
public class UbuntuWindowStyle extends WindowStyle {
    @Override
    public void useThisStyle() {
        System.out.println("this is ubuntu style");
    }
}
