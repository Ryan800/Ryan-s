package com.ryan.wangbw.mvp2.presenter;

import com.ryan.wangbw.mvp2.model.entity.Weather;

/**
 * author: wangbw
 * Date: 2015-12-17
 * Time: 14:56
 * Desc: 在Presenter层实现，给Model层回调，更改View层的状态，确保Model层不直接操作View层
 */
public interface OnWeatherListener {
    /**
     * 成功时回调
     *
     * @param weather
     */
    void onSuccess(Weather weather);
    /**
     * 失败时回调，简单处理，没做什么
     */
    void onError();

}
