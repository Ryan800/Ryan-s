package com.ryan.wangbw.javapattern.javapattern;

/**
 * author: wangbw
 * Date: 2015-12-01
 * Time: 11:42
 * Desc:
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        testRefactor();

        Duck model = new ModelDuck();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }

    private static void testRefactor() {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
    }
}
