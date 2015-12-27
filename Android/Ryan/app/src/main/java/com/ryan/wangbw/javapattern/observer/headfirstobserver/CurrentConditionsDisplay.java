package com.ryan.wangbw.javapattern.observer.headfirstobserver;

/**
 * author: wangbw
 * Date: 2015-12-18
 * Time: 11:40
 * Desc:
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Subject mWeatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.mWeatherData = weatherData;
        mWeatherData.addObserver(this);
    }

    @Override
    public void display() {
        WeatherData weatherData = (WeatherData) mWeatherData;
        System.out.println("Current conditions: " + weatherData.getTemperature()+"F degrees and "+
                weatherData.getHumidity() + "% humidity");
    }

    @Override
    public void update(Subject subject) {
        mWeatherData = subject;
        display();
    }
}
