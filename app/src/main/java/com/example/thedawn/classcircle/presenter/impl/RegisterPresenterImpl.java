package com.example.thedawn.classcircle.presenter.impl;

import android.util.Log;

import com.example.thedawn.classcircle.presenter.RegisterPresenter;
import com.example.thedawn.classcircle.utils.StringUtils;
import com.example.thedawn.classcircle.utils.ThreadUtils;
import com.example.thedawn.classcircle.view.RegisterView;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by The dawn on 2017/10/13.
 */

public class RegisterPresenterImpl implements RegisterPresenter {
    private static final String TAG = "RegisterPresenterImpl";
    private RegisterView mRegisterView;

    public RegisterPresenterImpl(RegisterView view){
        mRegisterView = view;
    }

    @Override
    public void register(String userName, String password, String confirmPassword) {
        //检查用户名是否符合要求
        if(StringUtils.isValidUserName(userName)){
            //继续检查密码
            if(StringUtils.isVaildPassword(password)){
                //密码正确
                //检查密码和确认密码是否一致
                if(password.equals(confirmPassword)){
                    //完全OK
                    //通知view层开始注册
                    mRegisterView.onStartRegister();
                    registerBmob(userName,password);
                }else {
                    //确认密码出错
                    //通知view层确认密码有问题
                    mRegisterView.onConfirmPasswordError();
                }
            }else {
                //不是有效密码
                //通知view层密码不符合规范
                mRegisterView.onPasswordError();
            }
        }else {
            //不是有效用户名
            //通知view层用户名出错
            mRegisterView.onUserNameError();
        }


    }

    public void registerBmob(final String userName, final String password){
        BmobUser bmobUser = new BmobUser();
        bmobUser.setUsername(userName);
        bmobUser.setPassword(password);
        bmobUser.signUp(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e == null){
                    //注册成功
                    // 通知view层注册成功
//                    mRegisterView.onRegisterSuccess();
                    //注册环信
                    registerEaseMob(userName,password);
                }else {
                    //注册失败
                    // 通知view层注册失败
                    mRegisterView.onRegisterFaild();
                }
            }
        });
    }

    private void registerEaseMob(final String userName, final String pawssword) {
/*        new Thread(new Runnable() {
            @Override
            public void run() {
                //注册失败会抛出HyphenateException
                try {
                    EMClient.getInstance().createAccount(userName, pawssword);//同步方法
                    //不拋表示注册成功
                    Log.d(TAG, "run: 注册成功");
                    mRegisterView.onRegisterSuccess();
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    //注册失败
                    Log.d(TAG, "run: 注册失败");
                }
            }
        }).start();*/
        ThreadUtils.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                 //注册失败会抛出HyphenateException
                try {
                    EMClient.getInstance().createAccount(userName, pawssword);//同步方法
                    //不拋表示注册成功
                    Log.d(TAG, "run: 注册成功");
                    //在主线程通知view注册成功
                    ThreadUtils.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            mRegisterView.onRegisterSuccess();
                        }
                    });
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    //注册失败
                    //在主线程通知view注册失败
                    Log.d(TAG, "run: 注册失败");
                    ThreadUtils.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            mRegisterView.onRegisterFaild();
                        }
                    });
                }
            }
        });
    }
}
