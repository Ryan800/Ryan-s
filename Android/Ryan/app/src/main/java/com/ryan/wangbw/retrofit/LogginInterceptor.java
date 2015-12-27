package com.ryan.wangbw.retrofit;

import com.socks.library.KLog;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * author: wangbw
 * Date: 2015-12-15
 * Time: 17:06
 * Desc:
 */
public class LogginInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
        KLog.i();

        return null;
    }
}
