package com.ryan.wangbw.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ryan.wangbw.base.BaseAty;
import com.ryan.wangbw.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnimatorActivity extends BaseAty {

    final static String TAG = AnimatorActivity.class.getSimpleName();

    @Bind(R.id.scaleBtn)
    Button mScaleBtn;
    @Bind(R.id.textview)
    TextView mTextView;
    @Bind(R.id.animateTv)
    TextView mAnimateTv;
    @Bind(R.id.animateBtn)
    Button mAnimateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        ButterKnife.bind(this);
    }

    public void scaleBtn(final View view) {
        final int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator
                .animator_scale);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currenValue = (int) animation.getAnimatedValue();
                view.getLayoutParams().width = maxWidth * currenValue / 100;
                view.requestLayout();
            }
        });

        valueAnimator.start();
    }

    public void onScaleWidth(View view) {
        int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
        ViewWrapper wrapper = new ViewWrapper(view, maxWidth);
        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator
                .animator_object);
        objectAnimator.setTarget(wrapper);
        objectAnimator.start();
    }

    private static class ViewWrapper {
        private View target;
        private int maxWidth;

        public ViewWrapper(View target, int maxWidth) {
            this.target = target;
            this.maxWidth = maxWidth;
        }

        public int getWidth() {
            return target.getLayoutParams().width;
        }

        public void setWidth(int widthValue) {
            target.getLayoutParams().width = maxWidth * widthValue / 100;
            target.requestLayout();
        }
    }

    public void objectAnimator(View view) {
        objectAlpha();
    }

    public void animate(View view) {
//        objectRotate();
//        objectTranslate();
        objectScale();
//        objectSet();
    }

    private void objectAlpha() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTextView, "alpha", 1f, 0f, 1f, 0.5f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

    private void objectRotate() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mAnimateTv, "rotation", 0f, 360f);
        animator.setDuration(3000);
        animator.start();
    }

    private void objectTranslate() {
        float curTranslationX = mAnimateTv.getTranslationX();
        Log.i(TAG, "objectTranslate: "+curTranslationX);

        ObjectAnimator animator = ObjectAnimator.ofFloat(mAnimateTv, "translationX",
                curTranslationX, -800f, curTranslationX);
        animator.setDuration(3000);
        animator.start();
    }

    private void objectScale() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mAnimateBtn, "scaleX", 1F, 2F);
        animator.setDuration(3000);
        animator.start();
    }

    private void objectSet() {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(mAnimateTv, "translationX", -800f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(mAnimateTv, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(mAnimateTv, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(3000);
        animSet.start();
        moveIn.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(AnimatorActivity.this, "animation end", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
