package com.ryan.wangbw.widget.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.socks.library.KLog;

/**
 * author: wangbw
 * Date: 2015-12-09
 * Time: 22:07
 * Desc:
 */
public class FontView extends View {

//    private final static String TEXT = "ap爱哥ξτβбпшㄎㄊěǔぬも┰┠№＠↓";
    private final static String TEXT = "MfgiA";
    private Paint mPaint;
    private Paint textPaint, linePaint; //文本画笔，中心线画笔

    private int baseX, baseY;   //baseline绘制的xy坐标
    private Paint.FontMetrics mFontMetrics; //文本测量对象

    public FontView(Context context) {
        this(context, null);
    }

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(50);
        mPaint.setColor(Color.BLACK);

        mFontMetrics = mPaint.getFontMetrics();

        KLog.d("Aige", "ascent：" + mFontMetrics.ascent);
        KLog.d("Aige", "top：" + mFontMetrics.top);
        KLog.d("Aige", "leading：" + mFontMetrics.leading);
        KLog.d("Aige", "descent：" + mFontMetrics.descent);
        KLog.d("Aige", "bottom：" + mFontMetrics.bottom);

        // 实例化画笔
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(70);
        textPaint.setColor(Color.BLACK);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(1);
        linePaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 计算baseline绘制的起点X轴坐标
        baseX = (int) (canvas.getWidth() / 2 - textPaint.measureText(TEXT) / 2);

        // 就按Baseline绘制的Y坐标
        baseY = (int) (canvas.getHeight() / 2/* - (textPaint.descent() + textPaint.ascent()) /
        2*/ - /*(Math.abs(textPaint.ascent())-Math.abs(textPaint.descent()))/2*/(textPaint.ascent()
                + textPaint.descent())/2);

        canvas.drawText(TEXT, baseX, baseY, textPaint);

        // 为了便于理解我们在互补中心会织一条中线
        canvas.drawLine(0, canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight() / 2, linePaint);

//        canvas.drawText(TEXT, 0, /*Math.abs(mFontMetrics.top)*/0, mPaint);

//        Typeface typeface = Typeface.createFromAsset(ctx.getAssets(), ".ttf");
    }
}
