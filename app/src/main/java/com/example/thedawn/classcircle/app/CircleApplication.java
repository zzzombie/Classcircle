package com.example.thedawn.classcircle.app;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BuildConfig;

/**
 * Created by The dawn on 2017/10/11.
 */

public class CircleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化一些全局的变量
        //初始化第三方的SDK
        //getApplicationContext获取application的上下文（context）
        //它的生命周期比普通的activity的上下文要长
        Bmob.initialize(getApplicationContext(), "27d0f89fe907c53d024a01527ca2b8f7");
        initEaseMob();
    }

    private void initEaseMob() {
        //创建环信配置
        EMOptions options = new EMOptions();
        //是否默认添加好友，true表示默认同意接受好友请求
        options.setAcceptInvitationAlways(true);

        //初始化
        EMClient.getInstance().init(getApplicationContext(), options);
        //如果是debug版本的apk，打开debug模式
        if(BuildConfig.DEBUG){
            EMClient.getInstance().setDebugMode(true);
        }
    }
}
