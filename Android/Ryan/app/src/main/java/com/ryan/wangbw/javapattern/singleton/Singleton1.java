package com.ryan.wangbw.javapattern.singleton;

/**
 * author: wangbw
 * Date: 2015-11-26
 * Time: 10:50
 * Desc: 饿汉模式
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
