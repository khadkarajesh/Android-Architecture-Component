package com.crushcoder.movie.di.module;


import com.crushcoder.movie.architecturecomponent.MovieListActivity;
import com.crushcoder.movie.fragment.MovieFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract MovieListActivity contributeActivityInjector();

    @ContributesAndroidInjector
    abstract MovieFragment movieFragment();
}
