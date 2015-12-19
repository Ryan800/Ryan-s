package com.ryan.wangbw.mvp2.ui.view;

import com.ryan.wangbw.mvp2.model.entity.Weather;

/**
 * author: wangbw
 * Date: 2015-12-17
 * Time: 14:59
 * Desc:
 */
public interface WeatherView {
    void showLoading();

    void hideLoading();

    void showError();

    void setWeatherInfo(Weather weather);
}
