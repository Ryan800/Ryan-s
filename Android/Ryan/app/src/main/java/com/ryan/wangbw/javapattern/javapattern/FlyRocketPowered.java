package com.ryan.wangbw.javapattern.javapattern;

/**
 * author: wangbw
 * Date: 2015-12-01
 * Time: 11:48
 * Desc:
 */
public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}
