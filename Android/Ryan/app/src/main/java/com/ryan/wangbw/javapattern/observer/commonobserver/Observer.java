package com.ryan.wangbw.javapattern.observer.commonobserver;

/**
 * author: wangbw
 * Date: 2015-11-24
 * Time: 17:07
 * Desc: 抽象观察者类，为所有具体观察者定义一个接口，在得到通知时更新自己
 */
public abstract class Observer {
    public abstract void update(String state);
}
