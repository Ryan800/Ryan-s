package com.ryan.wangbw.mvp2.app;

import android.app.Application;

import com.ryan.wangbw.mvp2.util.volley.VolleyRequest;
import com.ryan.wangbw.myapplication.BuildConfig;
import com.socks.library.KLog;

/**
 * author: wangbw
 * Date: 2015-12-17
 * Time: 14:51
 * Desc: 替换默认的Application实现
 */
public class App extends Application {
    private static App instance;

    public App() {
        instance = this;
    }

    public static Application getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(BuildConfig.LOG_DEBUG);
        VolleyRequest.buildRequestQueue(this);
    }
}
