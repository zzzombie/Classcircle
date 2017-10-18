package com.example.thedawn.classcircle.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by The dawn on 2017/10/14.
 */

public class ThreadUtils {
    //创建一个绑定主线程的LOOPER的handler
    //处理message或者runnnable都会在主线程执行
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    //在单线程的线程池中运行runnable

    public static Executor sExecutor = Executors.newSingleThreadExecutor();

    public static void runOnBackgroundThread(Runnable runnable){
        sExecutor.execute(runnable);
    }

    public static void runOnMainThread(Runnable runnable){
        mHandler.post(runnable);
    }
}
