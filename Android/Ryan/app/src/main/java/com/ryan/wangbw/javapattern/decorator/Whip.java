package com.ryan.wangbw.javapattern.decorator;

/**
 * author: wangbw
 * Date: 2015-12-08
 * Time: 11:19
 * Desc: ConcreteDecorator
 */
public class Whip extends CondimentDecorator {

    Beverage mBeverage;

    public Whip(Beverage beverage) {
        this.mBeverage = beverage;
    }

    @Override
    public String getDescription() {
        return mBeverage.getDescription()+", Whip";
    }

    @Override
    public double cost() {
        return 0.15 + mBeverage.cost();
    }
}
