package com.crushcoder.movie.di.module;


import com.crushcoder.movie.ui.login.LoginActivity;
import com.crushcoder.movie.ui.movie.MovieViewModelActivity;
import com.crushcoder.movie.ui.movie.MovieFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract MovieViewModelActivity contributeActivityInjector();

    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivity();

    @ContributesAndroidInjector
    abstract MovieFragment movieFragment();
}
