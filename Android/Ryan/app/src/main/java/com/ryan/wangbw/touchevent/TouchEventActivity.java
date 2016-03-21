package com.ryan.wangbw.touchevent;

import android.os.Bundle;
import android.view.MotionEvent;

import com.ryan.wangbw.base.BaseAty;
import com.ryan.wangbw.myapplication.R;
import com.socks.library.KLog;

import butterknife.OnClick;

public class TouchEventActivity extends BaseAty {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
    }

    @OnClick(R.id.mevgb)
    public void touchC() {
        KLog.i("touchB");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        KLog.i("Ryan", "TouchEventActivity dispatchTouchEvent "+TouchEventUtil.getTouchAction(ev
                .getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        KLog.i("Ryan", "TouchEventActivity onTouchEvent "+TouchEventUtil.getTouchAction(event
                .getAction()));
        return super.onTouchEvent(event);
    }
}
