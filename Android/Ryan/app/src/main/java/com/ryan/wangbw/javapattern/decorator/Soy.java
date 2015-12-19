package com.ryan.wangbw.javapattern.decorator;

/**
 * author: wangbw
 * Date: 2015-12-08
 * Time: 11:18
 * Desc: ConcreteDecorator
 */
public class Soy extends CondimentDecorator {

    Beverage mBeverage;

    public Soy(Beverage beverage) {
        this.mBeverage = beverage;
    }

    @Override
    public String getDescription() {
        return mBeverage.getDescription()+" ,Soy";
    }

    @Override
    public double cost() {
        return 0.30 + mBeverage.cost();
    }
}
