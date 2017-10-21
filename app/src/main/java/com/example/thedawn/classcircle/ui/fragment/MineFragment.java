package com.example.thedawn.classcircle.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thedawn.classcircle.R;
import com.example.thedawn.classcircle.ui.activity.LoginActivity;
import com.example.thedawn.classcircle.utils.ThreadUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by The dawn on 2017/10/19.
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.logout)
    Button mLogout;

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.mine_user)
    TextView mMineUser;

    @Override
    protected void init() {
        super.init();
        mTitle.setText(R.string.mine);
        String mineuser = String.format(getString(R.string.mineuser),EMClient.getInstance().getCurrentUser());
        mMineUser.setText(mineuser);


    }

    @Override
    public int getlayoutRes() {
        return R.layout.fragment_mine;
    }


    @OnClick(R.id.logout)
    public void onClick() {
        EMClient.getInstance().logout(true, new EMCallBack() {

            /**
             * 在子线程回调
             */
            @Override
            public void onSuccess() {
                ThreadUtils.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        goTo(LoginActivity.class);
                    }
                });
            }

            @Override
            public void onProgress(int progress, String status) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onError(int code, String message) {
                // TODO Auto-generated method stub
                ThreadUtils.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), getString(R.string.logout_failed), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
