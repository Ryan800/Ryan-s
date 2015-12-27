package com.ryan.wangbw.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * author: wangbw
 * Date: 2015-11-26
 * Time: 15:31
 * Desc:
 */
public class MyRecyclerView extends RecyclerView {

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private View mCurrentView;

    /**
     * 滚动时回调的接口
     */
    private OnItemScrollChangeListener mItemScrollChangeListener;

    public void setOnItemScrollChangeListener(OnItemScrollChangeListener itemScrollChangeListener) {
        this.mItemScrollChangeListener = itemScrollChangeListener;
    }


    public interface OnItemScrollChangeListener {
        void onChange(View view, int position);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mCurrentView = getChildAt(0);
        if (mItemScrollChangeListener != null) {
            mItemScrollChangeListener.onChange(mCurrentView, getChildAdapterPosition(mCurrentView));
        }
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent e) {
//        if (e.getAction() == MotionEvent.ACTION_MOVE) {
//            mCurrentView = getChildAt(0);
//            if (mItemScrollChangeListener != null) {
//                mItemScrollChangeListener.onChange(mCurrentView, getChildAdapterPosition(mCurrentView));
//            }
//        }
//        return super.onTouchEvent(e);
//    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
    }

    @Override
    public void onScrolled(int dx, int dy) {

        View newView = getChildAt(0);
        if (mItemScrollChangeListener != null) {
            if (newView != null && newView != mCurrentView) {
                mCurrentView = newView;
                mItemScrollChangeListener.onChange(mCurrentView, getChildAdapterPosition(mCurrentView));
            }
        }


        super.onScrolled(dx, dy);
    }
}
