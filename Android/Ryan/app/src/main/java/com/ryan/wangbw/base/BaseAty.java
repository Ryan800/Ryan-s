package com.ryan.wangbw.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

public abstract class BaseAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewConfiguration.get(this).getScaledTouchSlop();   //系统能识别出的最小滑动距离。
        VelocityTracker velocityTracker = VelocityTracker.obtain();
        Scroller scroller = new Scroller(this);
        TextView textView;
    }

    protected void skipAty(Class<?> clazz, boolean isFinish) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        if (isFinish) {
            finish();
        }
    }

    protected void TShort(int strId) {
        TShort(getString(strId));
    }
    
    protected void TShort(String str) {
        Toast.makeText(BaseAty.this, str, Toast.LENGTH_SHORT).show();
    }
}
