package com.ryan.wangbw.javapattern.observer.commonobserver;

/**
 * author: wangbw
 * Date: 2015-11-24
 * Time: 17:15
 * Desc:
 */
public class ConcreteObserver extends Observer {

    private String observerState;

    @Override
    public void update(String state) {
        observerState = state;
        System.out.println("状态为："+observerState);
    }
}
