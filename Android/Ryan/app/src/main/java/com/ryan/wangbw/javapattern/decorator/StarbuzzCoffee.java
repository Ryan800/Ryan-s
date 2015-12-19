package com.ryan.wangbw.javapattern.decorator;

/**
 * author: wangbw
 * Date: 2015-12-08
 * Time: 11:12
 * Desc:
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+" $"+beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);   //用macha装饰它
        beverage2 = new Mocha(beverage2);   //用第二个mocha装饰它
        beverage2 = new Whip(beverage2);    //用Whip装饰它
        System.out.println(beverage2.getDescription()+" $"+beverage2.cost());

        Beverage beverage3 = new HouseBlend();  //豆浆，摩卡，奶泡的HouseBlend咖啡
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription()+" $"+beverage3.cost());
        System.out.println(0.20+0.30+0.15+0.88);
    }
}
