package com.ryan.wangbw.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.socks.library.KLog;

/**
 * author: wangbw
 * Date: 2015-12-26
 * Time: 10:36
 * Desc:
 */
public class MotionEventViewGroupB extends LinearLayout {
    public MotionEventViewGroupB(Context context) {
        super(context);
    }

    public MotionEventViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MotionEventViewGroupB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        KLog.i("Ryan", "MotionEventViewGroupB dispatchTouchEventB "+TouchEventUtil.getTouchAction
                (ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        KLog.i("Ryan", "MotionEventViewGroupB onInterceptTouchEventB "+TouchEventUtil
                .getTouchAction(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        KLog.i("Ryan", "MotionEventViewGroupB onTouchEventB "+TouchEventUtil.getTouchAction(event
                .getAction()));
        return super.onTouchEvent(event);
    }
}
