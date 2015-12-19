package com.ryan.wangbw.drawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.ryan.wangbw.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnimationTestActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);
        ButterKnife.bind(this);
        mTextView.animate().x(500).y(500).setDuration(3000).setInterpolator(new
                BounceInterpolator());
    }
}
