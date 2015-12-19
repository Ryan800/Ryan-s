package com.ryan.wangbw.widget.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ryan.wangbw.myapplication.R;
import com.ryan.wangbw.utils.MeasureUtil;

/**
 * author: wangbw
 * Date: 2015-12-10
 * Time: 19:59
 * Desc:
 */
public class ShaderView extends View {

    private static final int RECT_SIZE = 300;// 矩形尺寸的一半

    private Paint mPaint;

    private Bitmap mBitmap;
    private Context mContext;

    private int left, top, right, bottom;

    private float posX, posY;

    public ShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        // 获取屏幕尺寸数据
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        // 获取屏幕中点坐标
        int screenX = screenSize[0] / 2;
        int screenY = screenSize[1] / 2;

        // 计算矩形左上右下坐标值
        left = screenX - RECT_SIZE;
        top = screenY - RECT_SIZE;
        right = screenX + RECT_SIZE;
        bottom = screenY + RECT_SIZE;

        initPaint(context);
    }

    private void initPaint(Context context) {

        // 获取屏幕尺寸数据
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        // 获取屏幕中点坐标
        int screenX = screenSize[0] / 2;
        int screenY = screenSize[1] / 2;

        // 计算矩形左上右下坐标值
        left = screenX - RECT_SIZE;
        top = screenY - RECT_SIZE;
        right = screenX + RECT_SIZE;
        bottom = screenY + RECT_SIZE;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.msg_game);
        Shader linearGradient = new LinearGradient(left, top, right, bottom, Color.RED, Color.YELLOW, Shader.TileMode.REPEAT);
        mPaint.setShader(linearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(left, top, right, bottom, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            posX = event.getX();
            posY = event.getY();

            invalidate();
        }
        return true;
    }
}
