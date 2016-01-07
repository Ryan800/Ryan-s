package com.ryan.wangbw.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.socks.library.KLog;

/**
 * author: wangbw
 * Date: 2015-12-26
 * Time: 10:40
 * Desc:
 */
public class MotionEventViewC extends View {
    public MotionEventViewC(Context context) {
        super(context);
    }

    public MotionEventViewC(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MotionEventViewC(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        KLog.i("Ryan", "MotionEventTouchC dispatchTouchEventC "+TouchEventUtil.getTouchAction
                (event.getAction()));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        KLog.i("Ryan", "MotionEventViewC onTouchEventC "+TouchEventUtil.getTouchAction(event.getAction()));
        return super.onTouchEvent(event);
    }
}
