package com.example.thedawn.classcircle.ui.fragment;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thedawn.classcircle.R;
import com.example.thedawn.classcircle.ui.activity.LoginActivity;
import com.example.thedawn.classcircle.utils.ThreadUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by The dawn on 2017/10/19.
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.logout)
    Button mLogout;

    @BindView(R.id.title)
    TextView mTitle;

    @Override
    protected void init() {
        super.init();
        mTitle.setText(R.string.mine);

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
}
