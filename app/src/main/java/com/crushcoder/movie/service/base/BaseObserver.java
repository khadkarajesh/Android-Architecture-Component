package com.crushcoder.movie.service.base;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    private Context activity;
    private MaterialDialog materialDialog;

    public BaseObserver(Context context) {
        this.activity = context;
//        materialDialog = new MaterialDialog.Builder(activity)
//                .content("Please wait..")
//                .progress(true, 0)
//                .show();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        //materialDialog.dismiss();
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        //materialDialog.dismiss();
        if (e instanceof RuntimeException) {
//            new MaterialDialog.Builder(activity)
//                    .title("error")
//                    .content(e.getLocalizedMessage())
//                    .show();
        }
    }

    @Override
    public void onComplete() {
        //hide progressbar
        //materialDialog.dismiss();
    }


    public abstract void onSuccess(T t);
}
