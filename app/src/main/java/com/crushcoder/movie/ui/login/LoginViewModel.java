package com.crushcoder.movie.ui.login;


import android.arch.lifecycle.ViewModel;
import android.view.View;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {
    @Inject
    public LoginViewModel() {

    }

    public void press(View view) {
        //Timber.d("login clicked" + nameField.get() + " " + passwordField.get());
    }
}
