package com.crushcoder.movie.ui.login;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.crushcoder.movie.R;
import com.crushcoder.movie.ValidationUtils;
import com.crushcoder.movie.databinding.ActivityLoginBinding;

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
        binding.setLoginViewModel(viewModel);

        User user = new User();
        user.password.set("rajesh");
        user.username.set("rajesh");
        user.url = "http://goo.gl/gEgYUd";
        binding.setUser(user);

    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @BindingAdapter("android:src")
    public static void setImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter({"app:textValue"})
    public static void onTextChanged(TextInputLayout textInputLayout, String textValue) {
        if (textValue == null) {
            return;
        }
        textInputLayout.setError(null);
        switch (textInputLayout.getId()) {
            case R.id.login_til_username:
                if (!ValidationUtils.isValidName(textValue)) {
                    textInputLayout.setError("first name can not be empty");
                }
                break;
            case R.id.login_til_password:
                if (!ValidationUtils.isValidPassword(textValue)) {
                    textInputLayout.setError("enter valid password");
                }
                break;
        }
    }
}
