package com.ryan.wangbw.javapattern.observer.headfirstobserver2;

import java.util.Observable;

/**
 * author: wangbw
 * Date: 2015-12-18
 * Time: 10:48
 * Desc:
 */
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){}

    public void measurementsChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
