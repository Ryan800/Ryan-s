package com.ryan.wangbw.widget.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.ryan.wangbw.myapplication.R;
import com.ryan.wangbw.utils.MeasureUtil;

/**
 * author: wangbw
 * Date: 2015-12-10
 * Time: 16:14
 * Desc:
 */
public class BlurMaskFilterView extends View {

    private Context mContext;
    private int x, y;
    private Bitmap srcBitmap, shadowBitmap;
    private Paint mShadowPaint;

    public BlurMaskFilterView(Context context) {
        this(context, null);
    }

    public BlurMaskFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        initPaint();
        initRes();
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    private void initPaint() {
        mShadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
        mShadowPaint.setColor(Color.DKGRAY);
        mShadowPaint.setMaskFilter(new BlurMaskFilter(15, BlurMaskFilter.Blur.NORMAL));
    }

    private void initRes() {
        srcBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.a);

        // 获取位图的alpha通道图
        shadowBitmap = srcBitmap.extractAlpha();

        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         */
        x = MeasureUtil.getScreenSize((Activity) mContext)[0] / 2 - srcBitmap.getWidth() / 2;
        y = MeasureUtil.getScreenSize((Activity) mContext)[1] / 2 - srcBitmap.getHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(shadowBitmap, x, y, mShadowPaint);

        canvas.drawBitmap(srcBitmap, x, y, null);
    }
}
