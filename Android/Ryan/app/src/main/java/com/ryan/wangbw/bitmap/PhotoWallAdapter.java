package com.ryan.wangbw.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.ryan.wangbw.myapplication.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * author: wangbw
 * Date: 2015-11-27
 * Time: 09:36
 * Desc:
 */
public class PhotoWallAdapter extends ArrayAdapter<String> implements AbsListView.OnScrollListener {

    private LruCache<String, Bitmap> mMemoryCache;

    /**
     * 记录所有正在下载或等待下载的任务
     */
    private Set<BitmapWorkerTadk> mTaskCollection;

    private GridView mPhotoWallGv;

    //第一张可见图片的下表
    private int mFirstVisibleItem;

    //一屏有多少张图片可见
    private int mVisibleItemCount;

    /**
     * 记录是否刚打开程序，用于解决进入程序不滚动屏幕，不会下载图片的问题
     */
    private boolean isFirstEnter = true;


    public PhotoWallAdapter(Context context, int textViewResourceId, String[] objects, GridView
            photoWall) {
        super(context, textViewResourceId, objects);
        mPhotoWallGv = photoWall;
        mTaskCollection = new HashSet<>();
        //获取应用程序最大可用内存的1/8
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<>(cacheSize);
        mPhotoWallGv.setOnScrollListener(this);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String url = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.photo_layout, parent, false);
        } else {
            view = convertView;
        }

        final ImageView photoIv = (ImageView) view.findViewById(R.id.photo);
        photoIv.setTag(url);
        setImageView(url, photoIv);
        return view;
    }

    /**
     * 给ImageView设置图片。首先从LruCache中取出图片的缓存，设置到ImageView上。如果LruCache中没有该图片的缓存，
     * 就给ImageView设置一张默认图片。
     *
     * @param imageUrl
     *            图片的URL地址，用于作为LruCache的键。
     * @param imageView
     *            用于显示图片的控件。
     */
    private void setImageView(String imageUrl, ImageView imageView) {
        Bitmap bitmap = getBitmapFromMemCache(imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.drawable.msg_gift);
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE) {
            loadBitmaps(mFirstVisibleItem, mVisibleItemCount);
        } else {
            cancelAllTasks();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        mFirstVisibleItem = firstVisibleItem;
        mVisibleItemCount = visibleItemCount;
        // 下载的任务应该由onScrollStateChanged里调用，但首次进入程序时onScrollStateChanged并不会调用，
        // 因此在这里为首次进入程序开启下载任务。
        if (isFirstEnter && visibleItemCount > 0) {
            loadBitmaps(firstVisibleItem, visibleItemCount);
            isFirstEnter = false;
        }
    }

    /**
     * 加载Bitmap对象。此方法会在LruCache中检查所有屏幕中可见的ImageView的Bitmap对象，
     * 如果发现任何一个ImageView的Bitmap对象不在缓存中，就会开启异步线程去下载图片。
     *
     * @param firstVisibleItem
     *            第一个可见的ImageView的下标
     * @param visibleItemCount
     *            屏幕中总共可见的元素数
     */
    private void loadBitmaps(int firstVisibleItem, int visibleItemCount) {
        try {
            for (int i=firstVisibleItem; i<firstVisibleItem+visibleItemCount; i++) {
                String imageUrl = Images.imageThumbUrls[i];
                Bitmap bitmap = getBitmapFromMemCache(imageUrl);
                if (bitmap == null) {
                    BitmapWorkerTadk task = new BitmapWorkerTadk();
                    mTaskCollection.add(task);
                    task.execute(imageUrl);
                } else {
                    ImageView imageView = (ImageView) mPhotoWallGv.findViewWithTag(imageUrl);
                    if (imageView != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消所有正在下载或等待下载的任务
     */
    public void cancelAllTasks() {
        if (mTaskCollection != null) {
            for (BitmapWorkerTadk task : mTaskCollection) {
                task.cancel(false);
            }
        }
    }

    private void cache() {
        //获取到可用内存的最大值，使用内存超出这个值会引起outOfMemory异常。
        //LruCache通过构造函数传入缓存值，以KB为单位
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //使用最大可用内存值的1/8最为缓存的大小
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //重写此方法来衡量每张图片的大小，默认返回图片数量
                return value.getByteCount() / 1024;
            }
        };

    }

    /**
     * 将一张图片存储到LruCache中。
     *
     * @param key
     *            LruCache的键，这里传入图片的URL地址。
     * @param bitmap
     *            LruCache的键，这里传入从网络上下载的Bitmap对象。
     */
    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    /**
     * 从LruCache中获取一张图片，如果不存在就返回null。
     *
     * @param key
     *            LruCache的键，这里传入图片的URL地址。
     * @return 对应传入键的Bitmap对象，或者null。
     */
    public Bitmap getBitmapFromMemCache(String key) {
        return mMemoryCache.get(key);
    }

    public void loadBitmap(int resId, ImageView imageView) {
        final String imageKey = String.valueOf(resId);
        final Bitmap bitmap = getBitmapFromMemCache(imageKey);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.drawable.msg_gift);

        }
    }

    class BitmapWorkerTadk extends AsyncTask<String, Void, Bitmap> {

        private String imageUrl;

        @Override
        protected Bitmap doInBackground(String... params) {
            final Bitmap bitmap = downloadBitmap(params[0]);
            if (bitmap != null) {
                addBitmapToMemoryCache(params[0], bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            ImageView imageView = (ImageView) mPhotoWallGv.findViewWithTag(imageUrl);
            if (imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            mTaskCollection.remove(this);
        }
    }

    private Bitmap downloadBitmap(String imgUrl) {
        Bitmap bitmap = null;
        HttpURLConnection con = null;
        try {
            URL url = new URL(imgUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5 * 1000);
            con.setReadTimeout(10 * 1000);
            bitmap = BitmapFactory.decodeStream(con.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return bitmap;
    }
}
