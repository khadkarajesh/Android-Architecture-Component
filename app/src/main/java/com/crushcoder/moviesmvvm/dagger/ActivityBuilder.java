package com.crushcoder.moviesmvvm.dagger;

import com.crushcoder.moviesmvvm.architecturecomponent.MovieListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = MovieActivityModule.class)
    abstract MovieListActivity bindActivity();
}
