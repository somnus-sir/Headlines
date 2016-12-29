package com.whn.whn.headline.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.facebook.drawee.backends.pipeline.Fresco;


/**
 * Created by whn on 2016/12/3.
 */

public class MyApplication extends Application {

    private static Handler handler;
    private static Context context;
    private static long id;


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        //获取主线程id
        handler = new Handler();
        context = getApplicationContext();
        id = Thread.currentThread().getId();



    }


    /**
     * 获取handler
     */
    public static Handler getHandler() {
        return handler;
    }


    /**
     * 获取上下文
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 获取主线程Id
     */
    public static long getMainThreadId() {
        return id;
    }


}
