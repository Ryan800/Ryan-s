package com.ryan.wangbw.mvp2.ui.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ryan.wangbw.mvp2.model.entity.Weather;
import com.ryan.wangbw.mvp2.model.entity.WeatherInfo;
import com.ryan.wangbw.mvp2.presenter.WeatherPresenter;
import com.ryan.wangbw.mvp2.presenter.impl.WeatherPresenterImpl;
import com.ryan.wangbw.mvp2.ui.common.BaseActivity;
import com.ryan.wangbw.mvp2.ui.view.WeatherView;
import com.ryan.wangbw.myapplication.R;

public class WeatherActivity extends BaseActivity implements WeatherView, View.OnClickListener {

    private Dialog loadingDialog;
    private EditText cityNOInput;
    private TextView city;
    private TextView cityNO;
    private TextView temp;
    private TextView wd;
    private TextView ws;
    private TextView sd;
    private TextView wse;
    private TextView time;
    private TextView njd;

    private WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        init();
    }

    private void init() {
        cityNOInput = findView(R.id.et_city_no);
        city = findView(R.id.tv_city);
        cityNO = findView(R.id.tv_city_no);
        temp = findView(R.id.tv_temp);
        wd = findView(R.id.tv_WD);
        ws = findView(R.id.tv_WS);
        sd = findView(R.id.tv_SD);
        wse = findView(R.id.tv_WSE);
        time = findView(R.id.tv_time);
        njd = findView(R.id.tv_njd);

        findView(R.id.btn_go).setOnClickListener(this);

        weatherPresenter = new WeatherPresenterImpl(this);
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setTitle("加载天气中...");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go:
                weatherPresenter.getWeather(cityNOInput.getText().toString().trim());
                break;
        }
    }

    @Override
    public void showLoading() {
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        loadingDialog.dismiss();
    }

    @Override
    public void showError() {
        Toast.makeText(WeatherActivity.this, "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWeatherInfo(Weather weather) {
        WeatherInfo info = weather.getWeatherinfo();
        city.setText(info.getCity());
        cityNO.setText(info.getCityid());
        temp.setText(info.getTemp());
        wd.setText(info.getWD());
        ws.setText(info.getWS());
        sd.setText(info.getSD());
        wse.setText(info.getWS());
        time.setText(info.getTemp());
        njd.setText(info.getNjd());
    }
}
