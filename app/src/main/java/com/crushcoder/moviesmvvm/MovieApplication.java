package com.crushcoder.moviesmvvm;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.crushcoder.moviesmvvm.dagger.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class MovieApplication extends Application implements HasActivityInjector {
    static Context context;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initializeComponent() {
        DaggerAppComponent.builder()
                .build()
                .inject(this);
    }

    public static Context get() {
        return context;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
