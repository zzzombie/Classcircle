package com.example.thedawn.classcircle.ui.activity;

import android.content.Intent;
import android.os.Handler;

import com.example.thedawn.classcircle.R;
import com.example.thedawn.classcircle.presenter.StartPresenter;
import com.example.thedawn.classcircle.presenter.impl.StartPresenterImpl;
import com.example.thedawn.classcircle.view.StartView;

/**
 * Created by The dawn on 2017/10/11.
 */

public class StartActivity extends BaseActivity implements StartView{

    private Handler mHandler = new Handler();

    private static final int DELAY = 2000;

    private StartPresenter mStartPresenter;

    @Override
    public int getlayoutRes() {
        return R.layout.activity_start;
    }

    @Override
    protected void init() {
        super.init();
        mStartPresenter = new StartPresenterImpl(this);
        mStartPresenter.checkLoginStatus();
    }

    private void navigateToLogin(){
        /*new Thread(){
            @Override
            public void run() {
                SystemClock.sleep(1500);
                enterLoginActivity();
            }
        }.start();*/
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                enterLoginActivity();
            }
        },DELAY);
    }


    private void enterLoginActivity() {
        Intent intent = new Intent(StartActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }



    @Override
    public void onLogginIn() {
        goTo(MainActivity.class);
    }

    @Override
    public void onNotLogin() {
        goTo(LoginActivity.class);
    }
}
