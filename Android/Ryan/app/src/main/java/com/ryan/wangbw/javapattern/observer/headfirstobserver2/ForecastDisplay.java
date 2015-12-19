package com.ryan.wangbw.javapattern.observer.headfirstobserver2;

import java.util.Observable;
import java.util.Observer;

/**
 * author: wangbw
 * Date: 2015-12-18
 * Time: 11:07
 * Desc:
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;

    private Observable mObservable;

    public ForecastDisplay(Observable observable) {
        this.mObservable = observable;
        mObservable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof WeatherData) {
            lastPressure = currentPressure;
            currentPressure = ((WeatherData) observable).getPressure();
            display();
        }

    }

    @Override
    public void display() {
        System.out.println("ForecastDisplay lastPressure:"+lastPressure+" and " +
                "currentPressure:"+currentPressure);
    }
}
