package com.ryan.wangbw.javapattern.observer.commonobserver;

/**
 * author: wangbw
 * Date: 2015-11-24
 * Time: 17:09
 * Desc: 具体观察者或具体通知者，将有关状态存入具体观察者对象；在具体主题的内部状态改变时，
 *       给所有登记过的观察者发出通知。具体主题角色通常用以各具体子类实现。
 */
public class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void channge(String newState) {
        state = newState;
        System.out.println("主题状态为："+state);
        this.notifi(newState);
    }
}
