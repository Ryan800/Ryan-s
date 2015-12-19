package com.ryan.wangbw.widget.customView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.ryan.wangbw.myapplication.R;

import java.lang.ref.WeakReference;

public class CustomViewActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private CustomView mCustomView;
    private int radius;

    private boolean isStop = false;

    private MyHandler mMyHandler = new MyHandler(this);

    class MyHandler extends Handler {

        WeakReference<Activity> mReference;

        public MyHandler(Activity activity) {
            mReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final Activity activity = mReference.get();
            if (activity!=null) {
                mCustomView.setRadius(radius);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.main_root_ll);
        mCustomView = (CustomView) findViewById(R.id.customView);
//        new Thread(mCustomView).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isStop = true;
        mMyHandler.removeCallbacksAndMessages(null);
    }
}
