package com.crushcoder.moviesmvvm.dagger;


import com.crushcoder.moviesmvvm.MovieApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, NetworkModule.class})
public interface AppComponent extends AndroidInjector<MovieApplication> {

}
