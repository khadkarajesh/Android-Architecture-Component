package com.crushcoder.movie.dagger;


import com.crushcoder.movie.MovieApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, NetworkModule.class})
public interface AppComponent extends AndroidInjector<MovieApplication> {

}
