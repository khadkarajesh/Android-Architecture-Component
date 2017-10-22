package com.crushcoder.moviesmvvm;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;


public class SimpleLifeCycleObserver implements LifecycleObserver {
    public static SimpleLifeCycleObserver bindInto(LifecycleOwner lifecycleOwner) {
        return new SimpleLifeCycleObserver(lifecycleOwner);
    }

    private SimpleLifeCycleObserver(LifecycleOwner provider) {
        provider.getLifecycle().addObserver(this);
    }
}
