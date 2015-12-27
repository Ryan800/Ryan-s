package com.ryan.wangbw.javapattern.javapattern;

/**
 * author: wangbw
 * Date: 2015-12-01
 * Time: 11:43
 * Desc:
 */
public class MallardDuck extends Duck {


    public MallardDuck() {
        mFlyBehavior = new FlyWithWings();
        mQuackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
