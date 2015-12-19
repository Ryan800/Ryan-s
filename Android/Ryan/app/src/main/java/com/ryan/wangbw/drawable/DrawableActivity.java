package com.ryan.wangbw.drawable;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.ryan.wangbw.base.BaseAty;
import com.ryan.wangbw.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrawableActivity extends BaseAty {

    @Bind(R.id.iv3)
    ImageView mImageView3;
    @Bind(R.id.iv4)
    ImageView mImageView4;
    @Bind(R.id.iv5)
    ImageView mImageView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        ButterKnife.bind(this);
        mImageView3.getDrawable().setLevel(5000);

    }

    @OnClick(R.id.playBtn)
    public void play() {
        ((TransitionDrawable)(mImageView4.getDrawable())).startTransition(500);
    }

    @OnClick(R.id.playBtn2)
    public void reverse() {
        ((TransitionDrawable) (mImageView4.getDrawable())).reverseTransition(1000);
    }

    @OnClick(R.id.animationBtn)
    public void startAnimation() {
        ((AnimationDrawable) (mImageView5.getDrawable())).start();
    }
}
