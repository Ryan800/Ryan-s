package com.ryan.wangbw.widget.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.ryan.wangbw.utils.MeasureUtil;

/**
 * author: wangbw
 * Date: 2015-12-10
 * Time: 15:36
 * Desc:
 */
public class MaskFilterView extends View {

    private static final int RECT_SIZE = 600;

    private Paint mPaint;
    private Context mContext;
    private int left, top, right, bottom;

    public MaskFilterView(Context context) {
        this(context, null);
    }

    public MaskFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initPaint();
        initRes();
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    private void initRes() {
        left = MeasureUtil.getScreenSize((Activity) mContext)[0]/2 - RECT_SIZE / 2;
        top = MeasureUtil.getScreenSize((Activity) mContext)[1]/2 - RECT_SIZE / 2;
        right = MeasureUtil.getScreenSize((Activity) mContext)[0]/2 + RECT_SIZE / 2;
        bottom = MeasureUtil.getScreenSize((Activity) mContext)[1]/2 + RECT_SIZE / 2;
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);

        //dx,dy 阴影平面上的偏移值
//        mPaint.setShadowLayer(radius, dx, dy, color);

        // 设置画笔遮罩滤镜
        mPaint.setMaskFilter(new BlurMaskFilter(20, BlurMaskFilter.Blur.SOLID));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);

        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
