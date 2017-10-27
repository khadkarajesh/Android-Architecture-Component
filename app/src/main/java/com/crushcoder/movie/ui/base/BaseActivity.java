package com.crushcoder.movie.ui.base;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    public ViewModelProvider.Factory factory;
    public ViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = getViewModel();
    }

    public abstract ViewModel getViewModel();
}
