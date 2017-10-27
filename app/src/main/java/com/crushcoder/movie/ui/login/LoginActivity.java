package com.crushcoder.movie.ui.login;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.crushcoder.movie.R;
import com.crushcoder.movie.databinding.ActivityLoginBinding;
import com.crushcoder.movie.service.request.LoginBody;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory factory;

    @Inject
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginBody loginBody = new LoginBody();
        loginBody.username = "rajesh";
        loginBody.password = "khadka";
        binding.setLoginViewModel(viewModel);
        binding.setUser(loginBody);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
