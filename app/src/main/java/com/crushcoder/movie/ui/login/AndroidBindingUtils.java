package com.crushcoder.movie.ui.login;


import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

public class AndroidBindingUtils {
    public TextWatcher textWatcher;
    public static void addTextWatcher(TextInputLayout textInputLayout, TextWatcher textWatcher) {
        textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
