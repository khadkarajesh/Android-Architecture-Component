package com.crushcoder.movie.di.component;

import com.crushcoder.movie.MovieApplication;
import com.crushcoder.movie.di.module.ActivityBuilder;
import com.crushcoder.movie.di.module.NetworkModuleTest;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ActivityBuilder.class, NetworkModuleTest.class})
public interface AppComponentTest extends AndroidInjector<MovieApplication> {

}