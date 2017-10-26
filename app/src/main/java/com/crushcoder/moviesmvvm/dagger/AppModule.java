package com.crushcoder.moviesmvvm.dagger;


import com.crushcoder.moviesmvvm.architecturecomponent.MovieListActivity;
import com.crushcoder.moviesmvvm.fragment.MovieFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {
    @ContributesAndroidInjector
    abstract MovieListActivity contributeActivityInjector();

    @ContributesAndroidInjector
    abstract MovieFragment movieFragment();
}
