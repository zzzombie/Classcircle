package com.example.thedawn.classcircle.ui.activity;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thedawn.classcircle.R;
import com.example.thedawn.classcircle.presenter.RegisterPresenter;
import com.example.thedawn.classcircle.presenter.impl.RegisterPresenterImpl;
import com.example.thedawn.classcircle.view.RegisterView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by The dawn on 2017/10/11.
 */
public class RegisterActivity extends BaseActivity implements RegisterView{
    @BindView(R.id.register_edt_username)
    EditText mRegisterEdtUsername;
    @BindView(R.id.register_edt_password)
    EditText mRegisterEdtPassword;
    @BindView(R.id.register_edt_compassword)
    EditText mRegisterEdtCompassword;
    @BindView(R.id.register_btn_register)
    Button mRegisterBtnRegister;

    private RegisterPresenter mRegisterPresenter;

    @Override
    public int getlayoutRes() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        super.init();
        mRegisterPresenter = new RegisterPresenterImpl(this);
        //设置软键盘ACTION的监听器，用户输入完确认密码后，点击软件盘的完成按钮，同样触发注册
        mRegisterEdtCompassword.setOnEditorActionListener(mOnEditorActionListener);
    }

    private TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId == EditorInfo.IME_ACTION_DONE){
                register();
                return true;
            }
            return false;
        }
    };




    @OnClick(R.id.register_btn_register)
    public void onClick() {
        //开始注册
        register();

    }

    private void register() {
        String userName = mRegisterEdtUsername.getText().toString().trim();
        String password = mRegisterEdtPassword.getText().toString().trim();
        String confirmPassword = mRegisterEdtCompassword.getText().toString().trim();

        hideKeyboard();
        //调用Presenter层来完成注册业务逻辑
        mRegisterPresenter.register(userName,password,confirmPassword);


    }

    @Override
    public void onRegisterSuccess() {
        showToast("注册成功");
        hideProgrssDialog();
        goTo(LoginActivity.class);
    }

    @Override
    public void onRegisterFaild() {
        showToast("注册失败");
    }

    @Override
    public void onUserNameError() {
        mRegisterEdtUsername.setError(getString(R.string.user_name_error));
    }

    @Override
    public void onPasswordError() {
        mRegisterEdtPassword.setError(getString(R.string.password_error));
    }

    @Override
    public void onConfirmPasswordError() {
        mRegisterEdtCompassword.setError(getString(R.string.confirm_password_error));
    }

    @Override
    public void onStartRegister() {
        showProgressDialog(getString(R.string.registering));
    }

    @Override
    public void onUserNameExist() {
        hideProgrssDialog();
        showToast(getString(R.string.user_name_exist));
    }
}
