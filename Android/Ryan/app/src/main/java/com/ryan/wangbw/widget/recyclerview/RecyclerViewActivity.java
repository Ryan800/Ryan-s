package com.ryan.wangbw.widget.recyclerview;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ryan.wangbw.myapplication.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private MyRecyclerView mRecyclerView;
    private ImageView mImg;

    private GalleryAdapter mGalleryAdapter;
    private List<Integer> mDatas;

    private static class MyHandler extends android.os.Handler {

        private final WeakReference<RecyclerViewActivity> mActivity;

        public MyHandler(RecyclerViewActivity activity) {
            mActivity = new WeakReference<RecyclerViewActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            RecyclerViewActivity activity = mActivity.get();
            if (activity!=null) {
                //啪啪啪
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initDatas();
        mRecyclerView = (MyRecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        mImg = (ImageView) findViewById(R.id.id_content);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mGalleryAdapter = new GalleryAdapter(this, mDatas);
        mRecyclerView.setAdapter(mGalleryAdapter);
        mRecyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                mImg.setImageResource(mDatas.get(position));
            }
        });
        mGalleryAdapter.setOnItemClickListener(new GalleryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(RecyclerViewActivity.this, "position:"+ postion, Toast.LENGTH_SHORT)
                        .show();
                mImg.setImageResource(mDatas.get(postion));
            }
        });
    }

    private void initDatas() {
        mDatas = new ArrayList<>(Arrays.asList(R.drawable.msg_game, R.drawable.msg_gift, R.drawable
                .msg_group_activity, R.drawable.msg_group_ad, R.drawable.msg_group_announcement, R.drawable
                .msg_group_photos, R.drawable.msg_group_room));
    }
}
