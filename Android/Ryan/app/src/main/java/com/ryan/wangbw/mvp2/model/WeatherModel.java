package com.ryan.wangbw.mvp2.model;

import com.ryan.wangbw.mvp2.presenter.OnWeatherListener;

/**
 * author: wangbw
 * Date: 2015-12-17
 * Time: 14:54
 * Desc: 天气Model接口
 */
public interface WeatherModel {
    void loadWeather(String cityNO, OnWeatherListener listener);
}
