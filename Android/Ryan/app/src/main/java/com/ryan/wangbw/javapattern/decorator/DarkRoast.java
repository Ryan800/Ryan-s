package com.ryan.wangbw.javapattern.decorator;

/**
 * author: wangbw
 * Date: 2015-12-08
 * Time: 11:29
 * Desc: ConcreteComponent
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 1.79;
    }
}
