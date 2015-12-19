package com.ryan.wangbw.javapattern.factorypattern;

/**
 * @author wangbw
 * @desc
 * @date 2015/10/29.
 */
public class TestMain {
    public static void main(String[] args) {
        ThemeFactory factory = new MacWindThemeFactory();
        WindowStyle windowStyle = factory.createWindowStyle();
        windowStyle.useThisStyle();
    }
}
