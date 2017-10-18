package com.example.thedawn.classcircle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by The dawn on 2017/10/11.
 */

public abstract class BaseActivity extends AppCompatActivity{
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutRes());
        ButterKnife.bind(this);

        initview();
        initListener();
        initData();
    }

    public abstract int getlayoutRes();
    /*初始化数据*/
    protected abstract void initData();

    /*设置监听器*/
    protected abstract void initListener();

    /*查找子控件*/
    public abstract void initview();

    private Toast mToast;

    public void showToast(String msg){
        if(mToast == null){
            mToast = Toast.makeText(this,"",Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    public void goTo(Class activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }
        /*
        * 弹出进度条
        * */
    public void showProgressDialog(String msg){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    public void hideProgrssDialog(){
        mProgressDialog.hide();
    }

    public void hideKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }
}