package com.example.thedawn.classcircle.view;

/**
 * Created by The dawn on 2017/10/13.
 */

public interface RegisterView {
    void onRegisterSuccess();

    void onRegisterFaild();

    void onUserNameError();

    void onPasswordError();

    void onConfirmPasswordError();

    void onStartRegister();
}
