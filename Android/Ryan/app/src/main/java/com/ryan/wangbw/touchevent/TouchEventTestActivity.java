package com.ryan.wangbw.touchevent;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ryan.wangbw.base.Base2Activity;
import com.ryan.wangbw.myapplication.R;
import com.socks.library.KLog;

import butterknife.Bind;

public class TouchEventTestActivity extends Base2Activity {

    private final static String TAG = "TouchTest";

    @Bind(R.id.btn)
    Button mButton;
    @Bind(R.id.iv)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
    }

    @Override
    protected int getRootView() {
        return R.layout.activity_touch_event_test;
    }

    private void test() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KLog.i(TAG, "onClick execute");
            }
        });

        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                KLog.i(TAG, "onTouch execute, action " + event.getAction());
                return false;
            }
        });

//        mImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                KLog.i(TAG, "onclick execute");
//            }
//        });
        mImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                KLog.i(TAG, "onTouch execute, action "+event.getAction());
                return false;
            }
        });
    }

}
