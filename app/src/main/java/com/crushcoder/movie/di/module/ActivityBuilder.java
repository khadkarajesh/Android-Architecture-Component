package com.crushcoder.movie.di.module;


import com.crushcoder.movie.ui.movie.MovieActivity;
import com.crushcoder.movie.ui.movie.MovieFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract MovieActivity contributeActivityInjector();

    @ContributesAndroidInjector
    abstract MovieFragment movieFragment();
}
