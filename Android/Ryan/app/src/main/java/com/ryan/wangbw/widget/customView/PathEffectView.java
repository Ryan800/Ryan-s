package com.ryan.wangbw.widget.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;


/**
 * author: wangbw
 * Date: 2015-12-10
 * Time: 16:32
 * Desc:
 */
public class PathEffectView extends View {

    private float mPhase;   //偏移值
    private Paint mPaint;
    private Path mPath; //路径对象
    private PathEffect[] mPathEffects;  //路径效果数组

    public PathEffectView(Context context) {
        this(context, null);
    }

    public PathEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.DKGRAY);

        //实例化路径
        mPath = new Path();
        mPath.moveTo(0, 0);

        for (int i=0; i<= 30; i++) {
            mPath.lineTo(i*35, (float) (Math.random()*100));
        }
        mPathEffects = new PathEffect[7];

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPathEffects[0] = null;
        mPathEffects[1] = new CornerPathEffect(10);
        mPathEffects[2] = new DiscretePathEffect(3f, 5f);
        mPathEffects[3] = new DashPathEffect(new float[]{20, 10, 5, 10}, mPhase);
        Path path = new Path();
        path.addRect(0, 0, 8, 8, Path.Direction.CCW);
        mPathEffects[4] = new PathDashPathEffect(path, 12, mPhase, PathDashPathEffect.Style.ROTATE);
        mPathEffects[5] = new ComposePathEffect(mPathEffects[2], mPathEffects[4]);
        mPathEffects[6] = new SumPathEffect(mPathEffects[4], mPathEffects[3]);

        /*
         * 绘制路径
         */
        for (int i = 0; i < mPathEffects.length; i++) {
            mPaint.setPathEffect(mPathEffects[i]);
            canvas.drawPath(mPath, mPaint);

            // 每绘制一条将画布向下平移250个像素
            canvas.translate(0, 150);
        }

        // 刷新偏移值病重回试图实现动画效果
        mPhase += 1;
        invalidate();
    }
}
