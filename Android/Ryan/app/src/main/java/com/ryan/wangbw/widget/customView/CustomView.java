package com.ryan.wangbw.widget.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;

import com.ryan.wangbw.myapplication.R;

/**
 * author: wangbw
 * Date: 2015-11-26
 * Time: 21:00
 * Desc:
 */
public class CustomView extends View implements Runnable {

    private Paint mPaint;
    private Context mContext;
    private int mRadius;    //圆环半径

    private Bitmap mBitmap;
    private int x,y;    //位图绘制时左上角的起点坐标

    private boolean isClick;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        initPaint();

        initRes(context);

//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isClick) {
//                    mPaint.setColorFilter(null);
//                    isClick = false;
//                } else {
//                    mPaint.setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0X00FFFF00));
//                    isClick = true;
//                }
//                invalidate();
//            }
//        });
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        /**
         * 画笔样式
         * 1.Paint.Style.STROKE:描边
         * 2.Paint.Style.FILL_AND_STROKE:描边并填充
         * 3.Paint.Style.FILL:填充
         */
        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.LTGRAY);
        mPaint.setColor(Color.argb(255, 255, 128, 103));
        //老旧
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0.393F, 0.769F, 0.189F, 0, 0,
//                0.349F, 0.686F, 0.168F, 0, 0,
//                0.272F, 0.534F, 0.131F, 0, 0,
//                0, 0, 0, 1, 0,
//        });
        //去色高对比度
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1.5F, 1.5F, 1.5F, 0, -1,
//                1.5F, 1.5F, 1.5F, 0, -1,
//                1.5F, 1.5F, 1.5F, 0, -1,
//                0, 0, 0, 1, 0,
//        });
        //黑白
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0.33F, 0.59F, 0.11F, 0, 0,
                0.33F, 0.59F, 0.11F, 0, 0,
                0.33F, 0.59F, 0.11F, 0, 0,
                0, 0, 0, 1, 0,
        });
//        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
//        mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
        mPaint.setStrokeWidth(10);
    }

    private void initRes(Context context) {
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.splash_iv);

        x = 30;
        y = 30;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawCircle(300, 300, 200, mPaint);
        canvas.drawBitmap(mBitmap, x, y, mPaint);
    }

    public synchronized void setRadius(int radius) {
        this.mRadius = radius;

        //重绘
        postInvalidate();
    }


    @Override
    public void run() {
        /*
         * 确保线程不断执行不断刷新界面
         */
        while (true) {
            try {
                /*
                 * 如果半径小于200则自加否则大于200后重置半径值以实现往复
                 */
                if (mRadius <= 200) {
                    mRadius += 10;

                    // 刷新View
                    postInvalidate();
                } else {
                    mRadius = 0;
                }

                // 每执行一次暂停40毫秒
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
