package com.ryan.wangbw.objectanimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.ryan.wangbw.drawable.Point;
import com.ryan.wangbw.drawable.PointEvaluator;
import com.socks.library.KLog;

/**
 * author: wangbw
 * Date: 2015-12-10
 * Time: 09:17
 * Desc:
 */
public class MyselfAnimView extends View {

    private Paint mPaint;
    private Point mCurrPoint;
    private String color;

    private float mRadius = 40;
    private final static float RADIUS = 40;

    public MyselfAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircle(canvas);
    }

    private void drawCircle(Canvas canvas) {
        if (mCurrPoint == null) {
            canvas.drawCircle(getWidth()/2, 0, RADIUS, mPaint);
            startAnimation();
        } else {
            canvas.drawCircle(getWidth()/2, RADIUS, mRadius, mPaint);
        }
    }

    private void startAnimation() {
        Point startPoint = new Point(getWidth()/2, 0);
        float endRadius = (float) (RADIUS *Math.pow(2, 6));
        Point endPoint = new Point(getWidth()/2, endRadius);
        final ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrPoint = (Point) animation.getAnimatedValue();
                float fraction = animation.getAnimatedFraction();
                mRadius = (float) (RADIUS * Math.pow(1 + fraction, 6));
                KLog.i("radius" + mRadius);
                invalidate();
            }
        });
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
//                anim.start();
            }
        });
        ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(anim).with(anim2);
        animatorSet.setDuration(2000);
        anim.setRepeatCount(5);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.start();
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
