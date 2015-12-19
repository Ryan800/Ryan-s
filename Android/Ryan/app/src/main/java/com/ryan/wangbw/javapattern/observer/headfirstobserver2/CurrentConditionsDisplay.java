package com.ryan.wangbw.javapattern.observer.headfirstobserver2;

import java.util.Observable;
import java.util.Observer;

/**
 * author: wangbw
 * Date: 2015-12-18
 * Time: 10:54
 * Desc:
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    Observable mObservable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.mObservable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions:"+temperature+" F degrees and "+ humidity + "% " +
                "humidity");
    }
}
