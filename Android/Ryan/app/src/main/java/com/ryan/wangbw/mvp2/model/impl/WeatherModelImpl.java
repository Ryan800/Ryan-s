package com.ryan.wangbw.mvp2.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ryan.wangbw.mvp2.model.WeatherModel;
import com.ryan.wangbw.mvp2.model.entity.Weather;
import com.ryan.wangbw.mvp2.presenter.OnWeatherListener;
import com.ryan.wangbw.mvp2.util.volley.VolleyRequest;

/**
 * author: wangbw
 * Date: 2015-12-17
 * Time: 14:55
 * Desc:
 */
public class WeatherModelImpl implements WeatherModel {
    @Override
    public void loadWeather(String cityNO, final OnWeatherListener listener) {
        /*数据层操作*/
        VolleyRequest.newInstance().newGsonRequest("http://www.weather.com.cn/data/sk/" + cityNO + ".html",
                Weather.class, new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather weather) {
                        if (weather != null) {
                            listener.onSuccess(weather);
                        } else {
                            listener.onError();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError();
                    }
                });
    }
}
