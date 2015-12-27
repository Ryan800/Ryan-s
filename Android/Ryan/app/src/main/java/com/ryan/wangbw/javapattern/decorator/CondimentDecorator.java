package com.ryan.wangbw.javapattern.decorator;

/**
 * author: wangbw
 * Date: 2015-12-08
 * Time: 11:04
 * Desc: 调料(抽象装饰者)
 */
public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}
