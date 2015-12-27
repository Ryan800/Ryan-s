package com.ryan.wangbw.widget.recyclerview2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryan.wangbw.myapplication.R;

import java.util.ArrayList;

/**
 * @author wangbw
 * @desc
 * @date 2015/11/16.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private ArrayList<String> mDatas;

    public HomeAdapter(ArrayList<String> datas) {
        this.mDatas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent,
                false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public MyViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.id_num);
        }
    }
}
