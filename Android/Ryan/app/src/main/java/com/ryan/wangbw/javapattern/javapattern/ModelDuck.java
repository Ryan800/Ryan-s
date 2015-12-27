package com.ryan.wangbw.javapattern.javapattern;

/**
 * author: wangbw
 * Date: 2015-12-01
 * Time: 11:47
 * Desc:
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        mFlyBehavior = new FlyNoWay();
        mQuackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }
}
