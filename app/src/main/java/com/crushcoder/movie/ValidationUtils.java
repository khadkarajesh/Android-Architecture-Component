package com.crushcoder.movie;


import android.text.TextUtils;

public class ValidationUtils {
    public static boolean isValidName(String name) {
        return !TextUtils.isEmpty(name);
    }

    public static boolean isValidPassword(String password) {
        return !TextUtils.isEmpty(password) && password.length() > 5;
    }
}
