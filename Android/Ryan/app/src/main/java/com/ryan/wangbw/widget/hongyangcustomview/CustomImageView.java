package com.ryan.wangbw.widget.hongyangcustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.ryan.wangbw.myapplication.R;

/**
 * author: wangbw
 * Date: 2016-01-07
 * Time: 10:15
 * Desc:
 */
public class CustomImageView extends View {

    private final static int IMAGE_SCALE_FITXY = 0;
    private final static int IMAGE_SCALE_CENTER = 1;

    private Bitmap mImage;
    private int mImageScale;
    private String mTitle;
    private int mTextColor;
    private int mTextSize;

    private Rect mRect;
    private Paint mPaint;
    private Rect mTextBound;
    private int mWidth;
    private int mHeight;

    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable
                .CustomImageView, defStyleAttr, 0);

        mImage = BitmapFactory.decodeResource(getResources(), a.getResourceId(R.styleable
                .CustomImageView_image, 0));
        mImageScale = a.getInt(R.styleable.CustomImageView_imageScaleType, 0);
        mTitle = a.getString(R.styleable.CustomImageView_titleText2);
        mTextColor = a.getColor(R.styleable.CustomImageView_titleTextColor2, Color.BLACK);
        mTextSize = a.getDimensionPixelSize(R.styleable.CustomImageView_titleTextSize2,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources()
                        .getDisplayMetrics()));

        a.recycle();

        init();
    }

    private void init() {
        mTextBound = new Rect();
        mPaint.getTextBounds(mTitle, 0, mTitle.length(), mTextBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /**
         * 设置宽度
         */
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            mWidth = specSize;
        } else {
            int desireByImg = getPaddingLeft() + getPaddingRight() + mImage.getWidth();
            int desireByTitle = getPaddingLeft() + getPaddingRight() + mTextBound.width();
            int desiredWidth = Math.max(desireByImg, desireByTitle);
            if (specMode == MeasureSpec.AT_MOST) {
                mWidth = Math.min(desiredWidth, specSize);
            } else {
                mWidth = Math.max(desiredWidth, specSize);
            }
        }

        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            mHeight = specSize;
        } else {
            int desireByImg = getPaddingTop() + getPaddingBottom() + mImage.getHeight();
            int desireByTitle = getPaddingTop() + getPaddingBottom() + mTextBound.height();
            int desiredHeight = Math.max(desireByImg, desireByTitle);
            if (specMode == MeasureSpec.AT_MOST) {  //此模式下，高度最大为spceSize,所以取两者最小值
                mHeight = Math.min(desiredHeight, specSize);
            } else {
                mHeight = Math.max(desiredHeight, specSize);
            }
        }

        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //边框
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.CYAN);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mRect.left = getPaddingLeft();
        mRect.right = mWidth - getPaddingRight();
        mRect.top = getPaddingTop();
//        mRect.bottom = mHeight - getPaddingBottom();
        mRect.bottom = mHeight - mTextBound.height() - getPaddingBottom();

        mPaint.setColor(mTextColor);
        mPaint.setStyle(Paint.Style.FILL);

        if (mTextBound.width() > mWidth) {
            TextPaint paint = new TextPaint(mPaint);
            String msg = TextUtils.ellipsize(mTitle, paint, (float) mWidth - getPaddingLeft() - getPaddingRight(),
                    TextUtils.TruncateAt.END).toString();
            canvas.drawText(msg, getPaddingLeft(), mHeight-getPaddingBottom(), mPaint);
        } else {
            canvas.drawText(mTitle, (mWidth-mTextBound.width())/2, mHeight-getPaddingBottom(), mPaint);
        }

//        mRect.bottom -= mTextBound.height();
        if (mImageScale == IMAGE_SCALE_FITXY) {
            canvas.drawBitmap(mImage, null, mRect, mPaint);
        } else {

        }
    }
}
