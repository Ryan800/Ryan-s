package com.ryan.wangbw.javapattern.observer.headfirstobserver;

import java.util.ArrayList;

/**
 * author: wangbw
 * Date: 2015-12-18
 * Time: 11:34
 * Desc:
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> mObservers;

    private float mTemperature;
    private float mHumidity;
    private float mPressure;

    public WeatherData() {
        mObservers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (mObservers.contains(observer)) {
            mObservers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i=0; i<mObservers.size(); i++) {
            Observer observer = mObservers.get(i);
            observer.update(this);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.mTemperature = temperature;
        this.mHumidity = humidity;
        this.mPressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return mTemperature;
    }

    public float getHumidity() {
        return mHumidity;
    }

    public float getPressure() {
        return mPressure;
    }
}
