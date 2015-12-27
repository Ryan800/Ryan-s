package com.ryan.wangbw.javapattern.observer.headfirstobserver2;

/**
 * author: wangbw
 * Date: 2015-12-18
 * Time: 11:14
 * Desc:
 */
public class HeadFristDemo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay
                (weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
    }
}
