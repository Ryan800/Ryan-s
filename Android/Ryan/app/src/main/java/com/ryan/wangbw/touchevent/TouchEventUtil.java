package com.ryan.wangbw.touchevent;

import android.view.MotionEvent;

/**
 * author: wangbw
 * Date: 2016-01-06
 * Time: 13:52
 * Desc:
 */
public class TouchEventUtil {

    public static String getTouchAction(int action) {
        String actionName = "Unknow:id="+action;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                actionName = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                actionName = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                actionName = "ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                actionName = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_OUTSIDE:
                actionName = "ACTION_OUTSIDE";
                break;
        }
        return actionName;
    }
}
