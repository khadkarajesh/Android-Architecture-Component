package com.crushcoder.moviesmvvm;


import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class ViewModel {
    private PublishSubject<List<Movie>> listObservable = PublishSubject.create();
    private DataModel mDataModel;

    public ViewModel(DataModel dataModel) {
        this.mDataModel = dataModel;
    }

    public void getMovies() {
        mDataModel.getMovies()
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Movie>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        listObservable.onNext(movies);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listObservable.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        listObservable.onComplete();
                    }
                });
    }

    public PublishSubject<List<Movie>> getListObservable() {
        return listObservable;
    }
}
