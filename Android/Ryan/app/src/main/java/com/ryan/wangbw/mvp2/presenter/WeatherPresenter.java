package com.ryan.wangbw.mvp2.presenter;

/**
 * author: wangbw
 * Date: 2015-12-17
 * Time: 14:57
 * Desc: 天气 Presenter接口
 */
public interface WeatherPresenter {
    /**
     * 获取天气的逻辑
     */
    void getWeather(String cityNO);

}
