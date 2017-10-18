package com.example.thedawn.classcircle.utils;

/**
 * Created by The dawn on 2017/10/13.
 */

public class StringUtils {

    public static final String REGEX_USER_NAME = "^[a-zA-Z]\\w{2,19}$";
    public static final String REGEX_PASSWORD = "[0-9]{3,20}";

    public static boolean isValidUserName(String userName){
        return userName.matches(REGEX_USER_NAME);
    }

    public static boolean isVaildPassword(String password){
        return password.matches(REGEX_PASSWORD);
    }
}
