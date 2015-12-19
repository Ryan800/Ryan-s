package com.ryan.wangbw.objectanimator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * author: wangbw
 * Date: 2015-12-10
 * Time: 10:46
 * Desc:
 */
public class MyAnimView extends View {

    private Paint mPaint;
    private String color;

    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }
}
