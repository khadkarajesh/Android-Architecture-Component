package com.crushcoder.movie.ui.movie;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.crushcoder.movie.service.ApiClient;
import com.crushcoder.movie.service.response.Movie;
import com.crushcoder.movie.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MovieViewModel extends BaseViewModel {
    ApiClient apiClient;
    MutableLiveData<List<Movie>> listLiveData = new MutableLiveData<>();
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public MovieViewModel(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public LiveData<List<Movie>> getMovies() {
        apiClient.getMovies("popular", 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new Observer<List<Movie>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Movie> movies) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return listLiveData;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
