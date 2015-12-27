package com.ryan.wangbw.javapattern.javapattern;

/**
 * author: wangbw
 * Date: 2015-12-01
 * Time: 11:41
 * Desc:
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
