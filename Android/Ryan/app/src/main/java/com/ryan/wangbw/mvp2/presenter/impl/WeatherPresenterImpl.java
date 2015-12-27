package com.ryan.wangbw.mvp2.presenter.impl;

import com.ryan.wangbw.mvp2.model.WeatherModel;
import com.ryan.wangbw.mvp2.model.entity.Weather;
import com.ryan.wangbw.mvp2.model.impl.WeatherModelImpl;
import com.ryan.wangbw.mvp2.presenter.OnWeatherListener;
import com.ryan.wangbw.mvp2.presenter.WeatherPresenter;
import com.ryan.wangbw.mvp2.ui.view.WeatherView;

/**
 * author: wangbw
 * Date: 2015-12-17
 * Time: 15:06
 * Desc: 天气 Prestener实现
 */
public class WeatherPresenterImpl implements WeatherPresenter/*, OnWeatherListener*/ {
    /*Presenter作为中间层，持有View和Model的引用*/
    private WeatherView weatherView;
    private WeatherModel weatherModel;

    public WeatherPresenterImpl(WeatherView weatherView) {
        this.weatherView = weatherView;
        weatherModel = new WeatherModelImpl();
    }

    @Override
    public void getWeather(String cityNO) {
        weatherView.showLoading();
        weatherModel.loadWeather(cityNO, new OnWeatherListener() {
            @Override
            public void onSuccess(Weather weather) {
                weatherView.hideLoading();
                weatherView.setWeatherInfo(weather);
            }

            @Override
            public void onError() {
                weatherView.hideLoading();
                weatherView.showError();
            }
        });
    }

//    @Override
//    public void onSuccess(Weather weather) {
//        weatherView.hideLoading();
//        weatherView.setWeatherInfo(weather);
//    }
//
//    @Override
//    public void onError() {
//        weatherView.hideLoading();
//        weatherView.showError();
//    }
}
