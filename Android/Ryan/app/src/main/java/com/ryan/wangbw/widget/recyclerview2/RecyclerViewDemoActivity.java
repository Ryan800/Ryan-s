package com.ryan.wangbw.widget.recyclerview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ryan.wangbw.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewDemoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private HomeAdapter mHomeAdapter;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        initDatas();
        mHomeAdapter = new HomeAdapter(mDatas);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i='A'; i<'z'; i++) {
            mDatas.add(""+ (char)i);
        }
    }

}
