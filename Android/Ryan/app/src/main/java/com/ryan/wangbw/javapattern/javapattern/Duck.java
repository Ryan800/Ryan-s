package com.ryan.wangbw.javapattern.javapattern;

/**
 * author: wangbw
 * Date: 2015-12-01
 * Time: 11:37
 * Desc:
 */
public abstract class Duck {
    FlyBehavior mFlyBehavior;
    QuackBehavior mQuackBehavior;

    public Duck() {};

    public void performFly() {
        mFlyBehavior.fly();
    }

    public void performQuack() {
        mQuackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        mFlyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        mQuackBehavior = qb;
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
}
