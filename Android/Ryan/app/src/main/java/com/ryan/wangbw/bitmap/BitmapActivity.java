package com.ryan.wangbw.bitmap;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageView;

import com.ryan.wangbw.myapplication.R;
import com.socks.library.KLog;

public class BitmapActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();

    private GridView mPhotoWallGv;
    private PhotoWallAdapter mWallAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
//        method1();
        method2();
        photoWall();
    }

    private void method1() {
        test();
    }

    //lazyload
    private void method2() {
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        test();
                    }
                });
            }
        });
    }

    private void photoWall() {
        mPhotoWallGv = (GridView) findViewById(R.id.photo_wall);
        mWallAdapter = new PhotoWallAdapter(this, 0, Images.imageThumbUrls, mPhotoWallGv);
        mPhotoWallGv.setAdapter(mWallAdapter);
    }

    private void test() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.splash_iv, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;
        KLog.i("Bitmap", "h:" + imageHeight + " w:" + imageWidth + " type:" + imageType);

        options.inSampleSize = calculateInSampleSize(options, 500, 500);
        options.inJustDecodeBounds = false;
        ((ImageView)findViewById(R.id.image)).setImageBitmap(BitmapFactory.decodeResource
                (getResources(), R.drawable.splash_iv, options));
        ((ImageView)findViewById(R.id.image2)).setImageBitmap(BitmapFactory.decodeResource
                (getResources(), R.drawable.splash_iv, options));
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height>reqHeight || width>reqWidth) {
            final int halfHeight = height/2;
            final int halfWidth = width/2;

            while ((halfHeight/inSampleSize > reqHeight) && (halfWidth/inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        KLog.i("size:"+inSampleSize);
        return inSampleSize;
    }
}
