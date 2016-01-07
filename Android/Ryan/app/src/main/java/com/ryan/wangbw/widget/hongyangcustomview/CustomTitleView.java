package com.ryan.wangbw.widget.hongyangcustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.ryan.wangbw.myapplication.R;
import com.socks.library.KLog;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 * author: wangbw
 * Date: 2016-01-06
 * Time: 17:14
 * Desc:
 */
public class CustomTitleView extends View {


    private String mTitleText;
    private int mTitleTextColor;
    private int mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;

    public CustomTitleView(Context context) {
        this(context, null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable
                .CustomTitleView, defStyleAttr, 0);
//        int n = a.getIndexCount();
//        for (int i=0; i<n; i++) {
//            int attr = a.getIndex(i);
//            switch (attr) {
//                case R.styleable.CustomTitleView_titleText2:
//                    mTitleText = a.getString(attr);
//                    break;
//
//                case R.styleable.CustomTitleView_titleTextColor2:
//                    mTitleTextColor = a.getColor(attr, Color.BLACK);
//                    break;
//                case R.styleable.CustomTitleView_titleTextSize2:
//                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
//                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
//                    break;
//            }
//        }

        mTitleText = a.getString(R.styleable.CustomTitleView_titleText2);
        mTitleTextColor = a.getColor(R.styleable.CustomTitleView_titleTextColor2, Color.BLACK);
        mTitleTextSize = a.getDimensionPixelSize(R.styleable.CustomTitleView_titleTextSize2,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources()
                        .getDisplayMetrics()));
        a.recycle();

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleText = randomText();
                invalidate();
            }
        });
    }

    private String randomText() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : set) {
            sb.append(i);
        }
        return sb.toString();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textWidth = mBound.width();
            int desiredWidth = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desiredWidth;
        }

        int height;
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textHeight = mBound.height();
            int desiredHeight = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desiredHeight;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        KLog.i("Ryan", "measuredWidth :" + getMeasuredHeight() + " measuredHeight:" + getMeasuredHeight());
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height()
                / 2, mPaint);
        KLog.i("Ryan", "width:" + getWidth() + " height:" + getHeight());
        KLog.i("Ryan", "bondWidth:"+mBound.width()+" bondHight:"+mBound.height());
    }
}
