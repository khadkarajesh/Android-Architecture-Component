package com.crushcoder.moviesmvvm;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

public class MovieApplication extends Application {
    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static Context get() {
        return context;
    }
}
