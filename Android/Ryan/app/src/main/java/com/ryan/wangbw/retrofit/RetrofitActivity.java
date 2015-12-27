package com.ryan.wangbw.retrofit;

import android.os.Bundle;

import com.ryan.wangbw.base.BaseAty;
import com.ryan.wangbw.myapplication.R;
import com.ryan.wangbw.utils.CommonUtil;
import com.socks.library.KLog;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class RetrofitActivity extends BaseAty {

    public static final String BASE = "http://27.221.58.228:8083";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        test();
    }

    private void test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApiEndpointInterface myApiService = retrofit.create(MyApiEndpointInterface.class);
        LoginRequest request = new LoginRequest();
        request.username = "18562513322";
        request.password = CommonUtil.md5("123456");
        request.timestamp = "20150627164101";
        request.signature = "02615e4eab8b4d6ecc152f29b319b230";
        myApiService.login(request).enqueue(new Callback<BaseResponse<WxResponse<LoginResponse>>>() {
            @Override
            public void onResponse(Response<BaseResponse<WxResponse<LoginResponse>>> response, Retrofit retrofit) {
                KLog.i(response.body().toString());
                if (response.body()!=null) {
                    BaseResponse<WxResponse<LoginResponse>> baseResponse = response.body();
                    if (baseResponse.getData()!=null) {
                        TShort("登录成功");
                        KLog.i(baseResponse.getData().getInfo().toString());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                KLog.i(t.getMessage());
            }
        });
    }
}
