package com.crushcoder.movie.ui.login;


import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginViewModel extends ViewModel {
    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    @Inject
    public LoginViewModel() {

    }

    public void onClick() {
        Timber.d(" valid name "+ username.get() + "valid password "+ password.get());
    }

}
