package com.ryan.wangbw.javapattern.observer.headfirstobserver;

/**
 * author: wangbw
 * Date: 2015-12-18
 * Time: 11:40
 * Desc:
 */
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay
                (weatherData);
        weatherData.setMeasurements(30, 40, 50);
    }
}
