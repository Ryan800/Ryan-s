package com.ryan.wangbw.javapattern.observer.headfirstobserver;

/**
 * author: wangbw
 * Date: 2015-12-18
 * Time: 09:51
 * Desc: 主题，被订阅者，被观察者
 */
public interface Subject {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
