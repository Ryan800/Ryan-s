package com.ryan.wangbw.javapattern.simplefactorypattern;

/**
 * @author wangbw
 * @desc Iphone5s类，对应ConcreteProduct角色
 * @date 2015/10/29.
 */
public class Iphone5s implements Iphone {
    @Override
    public void call() {
        System.out.println("用Iphone5s打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("用Iphone5s发短信");
    }

    @Override
    public void surfTheInternet() {
        System.out.println("用Iphone5s上网");
    }
}
