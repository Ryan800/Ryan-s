package com.ryan.wangbw.javapattern.observer.commonobserver;

/**
 * author: wangbw
 * Date: 2015-11-24
 * Time: 17:17
 * Desc:
 */
public class ObserverTest {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        Observer observer3 = new ConcreteObserver();
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);
        subject.channge("new state oh");
    }
}
