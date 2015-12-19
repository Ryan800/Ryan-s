package com.ryan.wangbw.widget.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.ryan.wangbw.myapplication.R;
import com.ryan.wangbw.utils.MeasureUtil;

/**
 * author: wangbw
 * Date: 2015-12-11
 * Time: 11:31
 * Desc:
 */
public class Shader2View extends View {

    private static final int RECT_SIZE = 400;

    private Paint mPaint;

    private int left, top, right, bottom;

    private int screenX, screenY;

    public Shader2View(Context context, AttributeSet attrs) {
        super(context, attrs);

        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenX = screenSize[0]/2;
        screenY = screenSize[1]/2;

        left = screenX - RECT_SIZE;
        top = screenY - RECT_SIZE;
        right = screenX + RECT_SIZE;
        bottom = screenY + RECT_SIZE;

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader
                .TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate(left, top);
        bitmapShader.setLocalMatrix(matrix);
        mPaint.setShader(bitmapShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRect(0, 0, screenX*2, screenY*2, mPaint);
        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
