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
public class MotionEventViewGroupA extends LinearLayout {
    public MotionEventViewGroupA(Context context) {
        super(context);
    }

    public MotionEventViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MotionEventViewGroupA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        KLog.i("Ryan", "MotionEventViewGroupA dispatchTouchEventA "+TouchEventUtil.getTouchAction
                (ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        KLog.i("Ryan", "MotionEventViewGroupA onInterceptTouchEventA "+TouchEventUtil
                .getTouchAction(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        KLog.i("Ryan", "MotionEventViewGroupA onTouchEventA "+ TouchEventUtil.getTouchAction
                (event.getAction()));
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
