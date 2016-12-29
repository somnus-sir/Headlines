package com.whn.whn.headline.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.whn.whn.headline.global.MyApplication;


/**
 * Created by whn on 2016/12/3.
 */

public class UIUtils {
    /**
     * 获取Context
     */
    public static Context getContext() {
        return MyApplication.getContext();
    }

    /**
     * 获取主线程ID
     */
    public static long getMainThreadID() {
        return MyApplication.getMainThreadId();
    }

        /**
         * 获取handler
         */
        public static Handler getHandler() {
            return MyApplication.getHandler();
        }


    /**
     * 获取资源文件xml->View
     */
    public static View inflate(int layoutID) {
        return View.inflate(getContext(), layoutID, null);
    }

    /**
     * 获取资源文件对象
     */
    public static Resources getResource() {
        return getContext().getResources();
    }

    /**
     * 从资源文件中获取字符串
     */
    public static String getString(int stringID) {
        return getResource().getString(stringID);
    }

    /**
     * 从资源文件中获取图片
     */
    public static Drawable getDrawable(int drawableID) {
        return getResource().getDrawable(drawableID);
    }

    /**
     * dp2px
     */
    public static int dp2px(int dp) {
        float density = getResource().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }


    /**
     * px2dp
     */
    public static int px2dp(int px) {
        float density = getResource().getDisplayMetrics().density;
        return (int) (px / density + 0.5f);
    }

    /**
     * 保证代码在主线程中运行
     */
    public static void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread().getId() == getMainThreadID()) {
            runnable.run();
        } else {
            getHandler().post(runnable);
        }
    }

    /**
     * 待...
     */
    public static ColorStateList getColorStateList(int colorStateListId) {
        return getResource().getColorStateList(colorStateListId);
    }


    /**
     * 获取stringArray
     */
    public static String[] getStringArray(int stringArrayID) {
        return getResource().getStringArray(stringArrayID);
    }

}
