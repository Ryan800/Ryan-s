package com.ryan.wangbw.widget.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.ryan.wangbw.myapplication.R;
import com.ryan.wangbw.utils.MeasureUtil;

/**
 * author: wangbw
 * Date: 2015-11-27
 * Time: 15:10
 * Desc: 测试DisIn模式View
 */
public class DisInView extends View {

    private Paint mPaint;
    private Bitmap bitmapDis, bitmapSrc;
    private PorterDuffXfermode mPorterDuffXfermode;

    private int x, y;
    private int screenW, screenH;

    public DisInView(Context context) {
        this(context, null);
    }

    public DisInView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        initPaint();
        initRes(context);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private void initRes(Context context) {
        bitmapDis = BitmapFactory.decodeResource(context.getResources(), R.drawable.a3);
        bitmapSrc = BitmapFactory.decodeResource(context.getResources(), R.drawable.a3_mask);

        int[] screenSIze = MeasureUtil.getScreenSize((Activity)context);

        screenW = screenSIze[0];
        screenH = screenSIze[1];

        x = screenW/2 - bitmapDis.getWidth()/2;
        y = screenH/2 - bitmapDis.getHeight()/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        // 先绘制一层颜色
        canvas.drawColor(0xFF8F66DA);
//        canvas.drawBitmap(bitmapDis, x, y, mPaint);
//        mPaint.setXfermode(mPorterDuffXfermode);
        canvas.drawBitmap(bitmapSrc, x, y, mPaint);
        // 还原混合模式
        mPaint.setXfermode(null);
        // 还原画布
        canvas.restoreToCount(sc);
    }
}
