package com.ryan.wangbw.javapattern.simplefactorypattern;

/**
 * @author wangbw
 * @desc Iphone4s类，对应ConcreteProduct角色
 * @date 2015/10/29.
 */
public class Iphone4s implements Iphone {
    @Override
    public void call() {
        System.out.println("用Iphone4s打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("用Iphone4s发短信");
    }

    @Override
    public void surfTheInternet() {
        System.out.println("用Iphone4s上网");
    }
}
