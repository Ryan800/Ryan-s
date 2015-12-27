package com.ryan.wangbw.javapattern.factorypattern;

/**
 * @author wangbw
 * @desc mac系统窗口风格，对应的是concreteProduct角色
 * @date 2015/10/29.
 */
public class MacWindowStyle extends WindowStyle {

    @Override
    public void useThisStyle() {
        System.out.println("this is mac style");
    }
}
