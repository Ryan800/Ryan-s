package com.ryan.wangbw.rxjava;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.ryan.wangbw.myapplication.R;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
//        testRx();
        test2();
    }

    private void testRx() {
        final int drawableRes = R.drawable.a;
        final ImageView imageView = (ImageView) findViewById(R.id.rxIv);
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getResources().getDrawable(drawableRes);
                subscriber.onNext(drawable);
            }
        })
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Observer<Drawable>() {
                    @Override
                    public void onNext(Drawable drawable) {
                        imageView.setImageDrawable(drawable);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCompleted() {
                    }
                });
    }

    private void test2() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
//                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .observeOn(Schedulers.computation())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        System.out.println("number:" + number);
                    }
                });
    }
}
