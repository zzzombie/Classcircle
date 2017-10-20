package com.example.thedawn.classcircle.ui.activity;

import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.thedawn.classcircle.R;
import com.example.thedawn.classcircle.utils.ThreadUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by The dawn on 2017/10/11.
 */
public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";


    @BindView(R.id.logo)
    TextView mLogo;
    @BindView(R.id.login_edt_username)
    EditText mLoginEdtUsername;
    @BindView(R.id.login_layout_edt_username)
    TextInputLayout mLoginLayoutEdtUsername;
    @BindView(R.id.linear_layout_user_name)
    LinearLayout mLinearLayoutUserName;
    @BindView(R.id.midle_line)
    LinearLayout mMidleLine;
    @BindView(R.id.login_edt_pwd)
    EditText mLoginEdtPwd;
    @BindView(R.id.login_layout_edt_pwd)
    TextInputLayout mLoginLayoutEdtPwd;
    @BindView(R.id.linear_layout_pwd)
    LinearLayout mLinearLayoutPwd;
    @BindView(R.id.radio_guanli)
    RadioButton mRadioGuanli;
    @BindView(R.id.radio_laoshi)
    RadioButton mRadioLaoshi;
    @BindView(R.id.radio_xuesheng)
    RadioButton mRadioXuesheng;
    @BindView(R.id.login_radiogroup)
    RadioGroup mLoginRadiogroup;
    @BindView(R.id.login_btn_login)
    Button mLoginBtnLogin;
    @BindView(R.id.login_register)
    TextView mLoginRegister;
    @BindView(R.id.linear_layout_btn_register)
    LinearLayout mLinearLayoutBtnRegister;

    @Override
    public int getlayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(){
        super.init();
    }


    @OnClick({R.id.login_btn_login, R.id.login_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn_login:
                login();
                break;
            case R.id.login_register:
                goTo(RegisterActivity.class);
                break;
        }
    }

    private void login() {
        showProgressDialog(getString(R.string.logining));
        hideKeyboard();
        String userName = mLoginEdtUsername.getText().toString().trim();
        String password = mLoginEdtPwd.getText().toString().trim();
        EMClient.getInstance().login(userName,password,new EMCallBack() {//回调
            /*
            * 在子线程回调
            * */
            @Override
            public void onSuccess() {
                Log.d(TAG, "onSuccess: " + Thread.currentThread().getName());
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.d("main", "登录聊天服务器成功！");
                ThreadUtils.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        hideProgrssDialog();
                        goTo(MainActivity.class);
                    }
                });
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.d("main", "登录聊天服务器失败！");
                ThreadUtils.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        hideProgrssDialog();
                    }
                });
            }
        });
    }
}
