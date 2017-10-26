package com.crushcoder.movie.dagger;


import com.crushcoder.movie.architecturecomponent.MovieListActivity;
import com.crushcoder.movie.fragment.MovieFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {
    @ContributesAndroidInjector
    abstract MovieListActivity contributeActivityInjector();

    @ContributesAndroidInjector
    abstract MovieFragment movieFragment();
}
