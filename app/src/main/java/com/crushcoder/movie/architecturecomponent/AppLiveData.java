package com.crushcoder.movie.architecturecomponent;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


public class AppLiveData<T> extends LiveData<T> {
    private Context context = null;
    Disposable disposable;

    public AppLiveData(Context context) {
        this.context = context;
    }

    public void getData(Observable<T> observable){
        
    }
}
