package com.ryan.wangbw.drawable;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.ryan.wangbw.base.BaseAty;
import com.ryan.wangbw.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends BaseAty {

    @Bind(R.id.alphaIv)
    ImageView mAlphaIv;
    @Bind(R.id.scaleIv)
    ImageView mScaleIv;
    @Bind(R.id.translateIv)
    ImageView mTranslateIv;
    @Bind(R.id.rotateIv)
    ImageView mRotateIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.alphaBtn)
    public void alpha() {
        AlphaAnimation animation = (AlphaAnimation) AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        mAlphaIv.startAnimation(animation);
    }

    @OnClick(R.id.scaleBtn)
    public void scale() {
        ScaleAnimation animation = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim
                .anim_scale);
        mScaleIv.startAnimation(animation);
    }

    @OnClick(R.id.translateBtn)
    public void translate() {
        TranslateAnimation animation = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim
                .anim_translate);
        mTranslateIv.startAnimation(animation);
    }

    @OnClick(R.id.animateBtn)
    public void rotate() {
        RotateAnimation animation = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim
                .anim_rotate);
        mRotateIv.startAnimation(animation);
    }

    private void test(Canvas canvas) {
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

    }

}
