package com.ryan.wangbw.widget.hongyangcustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.ryan.wangbw.myapplication.R;

/**
 * author: wangbw
 * Date: 2016-01-08
 * Time: 16:13
 * Desc:
 */
public class CustomVolumControlBar extends View {

    /**
     * 第一圈的颜色
     */
    private int mFirstColor;

    /**
     * 第二圈的颜色
     */
    private int mSecondColor;
    /**
     * 圈的宽度
     */
    private int mCircleWidth;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 当前进度
     */
    private int mCurrentCount = 3;

    /**
     * 中间的图片
     */
    private Bitmap mImage;
    /**
     * 每个块块间的间隙
     */
    private int mSplitSize;
    /**
     * 个数
     */
    private int mCount;

    private Rect mRect;

    public CustomVolumControlBar(Context context) {
        this(context, null);
    }

    public CustomVolumControlBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomVolumControlBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomVolumControlBar, defStyleAttr, 0);
        mFirstColor = a.getColor(R.styleable.CustomVolumControlBar_firstColor, Color.GREEN);
        mSecondColor = a.getColor(R.styleable.CustomVolumControlBar_secondColor, Color.CYAN);
        mImage = BitmapFactory.decodeResource(getResources(), a.getResourceId(R.styleable.CustomVolumControlBar_bg, 0));
        mCircleWidth = a.getDimensionPixelSize(R.styleable.CustomVolumControlBar_circleWidth,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics()));
        mCount = a.getInt(R.styleable.CustomVolumControlBar_dotCount, 20);
        mSplitSize = a.getInt(R.styleable.CustomVolumControlBar_splitSize, 20);
        a.recycle();

        init();
    }

    private void init() {
        mPaint = new Paint();
        mRect = new Rect();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(mCircleWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth()/2;
        int radius = center-mCircleWidth/2;
        //画块
        drawOval(canvas, center, radius);
        int relRadius = radius - mCircleWidth/2;    //获得内圆半径
        /**
         * 内切正方形的距离顶部 = mCircleWidth + relRadius*(1 - √2 / 2)
         */
        mRect.top = (int) (relRadius - Math.sqrt(2) * 1.0f / 2 * relRadius) + mCircleWidth;
        mRect.left = (int) (relRadius - Math.sqrt(2) * 1.0f/2 * relRadius) + mCircleWidth;
        mRect.right = (int) (mRect.left + Math.sqrt(2) * relRadius);
        mRect.bottom = (int) (mRect.top + Math.sqrt(2) * relRadius);

        float halfSqure = (float)(Math.sqrt(2)*1.0f/2 * relRadius);

        if (mImage.getWidth() < Math.sqrt(2) * relRadius) {
            mRect.left = (int) (mRect.left + halfSqure - mImage.getWidth()/2);
            mRect.top = (int) (mRect.top + halfSqure - mImage.getHeight()/2);
            mRect.right = (int) (mRect.left + mImage.getWidth());
            mRect.bottom = (int) (mRect.top + mImage.getHeight());
        }

        canvas.drawBitmap(mImage, null, mRect, mPaint);

    }

    /**
     * 根据参数画出每个小块
     * @param canvas
     * @param centre
     * @param radius
     */
    private void drawOval(Canvas canvas, int centre, int radius) {

        float itemSize = (360 * 1.0f - mCount * mSplitSize) / mCount;
        RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius); // 用于定义的圆弧的形状和大小的界限
        mPaint.setColor(mFirstColor);
        for (int i=0; i<mCount; i++) {
            //第三个参数是sweepAngle划过的角度
            canvas.drawArc(oval, i * (itemSize + mSplitSize), itemSize, false, mPaint);
        }
        mPaint.setColor(mSecondColor);
        for (int i=0; i<mCurrentCount; i++) {
            canvas.drawArc(oval, i*(itemSize + mSplitSize), itemSize, false, mPaint);
        }
    }

    public void up(int change) {
        mCurrentCount = mCurrentCount + change;
        postInvalidate();
    }

    public void down(int change) {
        mCurrentCount = mCurrentCount-change;
        postInvalidate();
    }

    private int xDown, xUp;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDown = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
                xUp = (int) event.getY();
                int delta = Math.abs(xDown-xUp)/30;
                if (xUp > xDown) {
                    down(delta);
                } else {
                    up(delta);
                }
                break;
        }
        return true;
    }
}
