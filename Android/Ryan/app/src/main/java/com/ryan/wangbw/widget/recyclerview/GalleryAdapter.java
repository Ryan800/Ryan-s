package com.ryan.wangbw.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryan.wangbw.myapplication.R;

import java.util.List;

/**
 * @author wangbw
 * @desc
 * @date 2015/11/11.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View view, int postion);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    private LayoutInflater mInflater;
    private List<Integer> mDatas;

    public GalleryAdapter(Context context, List<Integer> mDatas) {
        mInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    //创建ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mImageView = (ImageView) view.findViewById(R.id.id_index_gallery_item_image);
        return viewHolder;
    }

    //设置值
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mImageView.setImageResource(mDatas.get(position));
        if (mOnItemClickListener!=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView mImageView;
        TextView mTextView;
    }
}
