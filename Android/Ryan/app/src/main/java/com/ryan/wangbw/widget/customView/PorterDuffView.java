package com.ryan.wangbw.widget.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.ryan.wangbw.utils.MeasureUtil;

/**
 * author: wangbw
 * Date: 2015-11-26
 * Time: 22:11
 * Desc:
 */
public class PorterDuffView extends View {

    /**
     * PorterDuff模式常量
     * 可以在此更改不同的模式测试
     */
    private static final PorterDuff.Mode MODE = PorterDuff.Mode.DST_ATOP;

    private static final int RECT_SIZE_SMALL = 400;// 左右上方示例渐变正方形的尺寸大小
    private static final int RECT_SIZE_BIG = 800;// 中间测试渐变正方形的尺寸大小

    private Paint mPaint;

    private PorterDuffBO mPorterDuffBO; //业务对象
    private PorterDuffXfermode mPorterDuffXfermode; //图形混合模式

    private int screenW, screenH;   //屏幕尺寸
    private int s_l, s_t;   //左上方正方形的原点坐标
    private int d_l, d_t;   //右上方正方形的原点坐标
    private int rectX, rectY;   //中间正方形的原点坐标

    public PorterDuffView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        //实例化业务对象
        mPorterDuffBO = new PorterDuffBO();
        //实例化混合模式
        mPorterDuffXfermode = new PorterDuffXfermode(MODE);

        //计算坐标
        calu(context);
    }

    /**
     * 计算坐标
     * @param context
     */
    private void calu(Context context) {
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenW = screenSize[0];
        screenH = screenSize[1];

        //计算左上方正方形圆点坐标
        s_l = 0;
        s_t = 0;

        //计算右上方正方形原点坐标
        d_l = screenW - RECT_SIZE_SMALL;
        d_t = 0;

        //计算中间正方形原点坐标
        rectX = screenW / 2 - RECT_SIZE_BIG / 2;
        rectY = RECT_SIZE_SMALL + (screenH - RECT_SIZE_SMALL) / 2 - RECT_SIZE_BIG / 2;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置画布颜色为黑色以便我们更好地观察
        canvas.drawColor(Color.BLACK);

        //设置业务对象尺寸值计算生成左右上方的渐变方形
        mPorterDuffBO.setSize(RECT_SIZE_SMALL);

        /*
         * 画出左右上方两个正方形
         * 其中左边的的为src右边的为dis
         */
        canvas.drawBitmap(mPorterDuffBO.initSrcBitmap(), s_l, s_t, mPaint);
        canvas.drawBitmap(mPorterDuffBO.initDisBitmap(), d_l, d_t, mPaint);

        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        //重新设置业务对象尺寸值计算生成中间的渐变方形
        mPorterDuffBO.setSize(RECT_SIZE_BIG);

        // 先绘制dis目标图
        canvas.drawBitmap(mPorterDuffBO.initDisBitmap(), rectX, rectY, mPaint);

        // 设置混合模式
        mPaint.setXfermode(mPorterDuffXfermode);

        // 再绘制src原图
        canvas.drawBitmap(mPorterDuffBO.initSrcBitmap(), rectX, rectY, mPaint);

        // 还原混合模式
        mPaint.setXfermode(null);

        // 还原画布
        canvas.restoreToCount(sc);
    }
}
