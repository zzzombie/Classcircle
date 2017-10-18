package com.example.thedawn.classcircle.presenter.impl;

import com.example.thedawn.classcircle.presenter.StartPresenter;
import com.example.thedawn.classcircle.view.StartView;
import com.hyphenate.chat.EMClient;

/**
 * Created by The dawn on 2017/10/16.
 */

public class StartPresenterImpl implements StartPresenter {

    private StartView mStartView;

    public StartPresenterImpl(StartView view){
        mStartView = view;
    }


    @Override
    public void checkLoginStatus() {
        if (isLoggedIn()){
            mStartView.onLogginIn();
        }else {
            mStartView.onNotLogin();
        }
    }

    private boolean isLoggedIn() {
        return EMClient.getInstance().isLoggedInBefore() && EMClient.getInstance().isConnected();
    }
}
