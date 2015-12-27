package com.ryan.wangbw.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 测绘工具类
 * 
 * @author Aige
 * @since 2014/11/19
 */
public final class MeasureUtil {
	/**
	 * 获取屏幕尺寸
	 *
	 * @param activity
	 *            Activity
	 * @return 屏幕尺寸像素值，下标为0的值为宽，下标为1的值为高
	 */
	public static int[] getScreenSize(Activity activity) {
		DisplayMetrics metrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int statusBarH = getStatusBarHeight(activity);
		return new int[] { metrics.widthPixels - statusBarH, metrics.heightPixels - statusBarH };
	}

	/**
	 * 获取状态栏高度
	 * @param context
	 * @return
	 */
	public static int getStatusBarHeight(Context context) {
		int result = 0;
		int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = context.getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}
}
