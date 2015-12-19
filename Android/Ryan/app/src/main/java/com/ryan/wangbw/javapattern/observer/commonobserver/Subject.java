package com.ryan.wangbw.javapattern.observer.commonobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * author: wangbw
 * Date: 2015-11-24
 * Time: 17:02
 * Desc: 抽象主题类
 */
public abstract class Subject {
    private List<Observer> mObservers = new ArrayList<>();

    public void attach(Observer observer) {
        mObservers.add(observer);
    }

    public void detach(Observer observer) {
        mObservers.remove(observer);
    }

    public void notifi(String state) {
        for (Observer o : mObservers) {
            o.update(state);
        }
    }
}
