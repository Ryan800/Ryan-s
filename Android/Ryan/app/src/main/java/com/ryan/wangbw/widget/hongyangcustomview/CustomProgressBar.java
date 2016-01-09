package com.ryan.wangbw.widget.hongyangcustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.ryan.wangbw.myapplication.R;
import com.socks.library.KLog;

/**
 * author: wangbw
 * Date: 2016-01-08
 * Time: 10:54
 * Desc:
 */
public class CustomProgressBar extends View {

    private int mFirstColor;
    private int mSecondColor;
    private int mCircleWidth;
    private Paint mPaint;
    private int mProgress;  //当前进度
    private int mSpeed; //速度
    private RectF mOval;
    private int mRadius;    //圆半径
    private int mCenter;    //圆中心x坐标

    private boolean isNext = false; //是否应该开始下一个

    public CustomProgressBar(Context context) {
        this(context, null);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i=0; i<n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomProgressBar_firstColor:
                    mFirstColor = a.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.CustomProgressBar_secondColor:
                    mSecondColor = a.getColor(attr, Color.RED);
                    break;
                case R.styleable.CustomProgressBar_circleWidth:
                    mCircleWidth = a.getDimensionPixelSize(attr,
                            (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomProgressBar_speed:
                    mSpeed = a.getInt(attr, 20);
                    break;
            }
        }
        a.recycle();

        init();
    }

    private void init() {
        mPaint = new Paint();
//        mCenter = getWidth()/2;
//        mRadius = mCenter - mCircleWidth/2;
//        mOval = new RectF(mCenter-mRadius, mCenter-mRadius, mCenter+mRadius, mCenter+mRadius);
        new Thread() {
            @Override
            public void run() {
                while(true) {
                    mProgress++;
                    if (mProgress == 360) {
                        mProgress = 0;
                        if (!isNext) {
                            isNext = true;
                        } else {
                            isNext = false;
                        }
                    }
                    postInvalidate();
                    try {
                        Thread.sleep(mSpeed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        KLog.i("onMeasure");
//        mCenter = getWidth()/2;
//        mRadius = mCenter - mCircleWidth/2;
//        if (mCenter!=0||mOval==null)
//            mOval = new RectF(mCenter-mRadius, mCenter-mRadius, mCenter+mRadius, mCenter+mRadius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        KLog.i("onDraw"+mProgress);
        int mCenter = getWidth() / 2; // 获取圆心的x坐标
        int mRadius = mCenter - mCircleWidth / 2;// 半径
        if (mOval== null) {
            mOval = new RectF(mCenter - mRadius, mCenter - mRadius, mCenter + mRadius, mCenter + mRadius); // 用于定义的圆弧的形状和大小的界限
        }
        mPaint.setStrokeWidth(mCircleWidth);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);

        if (!isNext) {
            mPaint.setColor(mFirstColor);
            canvas.drawCircle(mCenter, mCenter, mRadius, mPaint); // 画出圆环
            mPaint.setColor(mSecondColor);
            canvas.drawArc(mOval, -90, mProgress, false, mPaint);
        } else {
            mPaint.setColor(mSecondColor);
            canvas.drawCircle(mCenter, mCenter, mRadius, mPaint); // 画出圆环
            mPaint.setColor(mFirstColor);
            canvas.drawArc(mOval, -90, mProgress, false, mPaint);
        }
    }
}
