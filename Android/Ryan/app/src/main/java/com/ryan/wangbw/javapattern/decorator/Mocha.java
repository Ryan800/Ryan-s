package com.ryan.wangbw.javapattern.decorator;

/**
 * author: wangbw
 * Date: 2015-12-08
 * Time: 11:08
 * Desc: ConcreteDecorator
 */
public class Mocha extends CondimentDecorator {

    Beverage mBeverage;

    public Mocha(Beverage beverage) {
        this.mBeverage = beverage;
    }

    @Override
    public String getDescription() {
        return mBeverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + mBeverage.cost();
    }
}
