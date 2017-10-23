package com.crushcoder.moviesmvvm.architecturecomponent;


import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.crushcoder.moviesmvvm.BuildConfig;
import com.crushcoder.moviesmvvm.Movie;
import com.crushcoder.moviesmvvm.rest.ApiClient;
import com.crushcoder.moviesmvvm.rest.base.BaseObserver;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DataRepository extends LiveData {
    private ApiClient mApiClient;
    private Activity mContext;
    private Disposable disposable;

    @Inject
    public DataRepository(ApiClient apiClient) {
        //mApiClient = ApiService.INSTANCE.get();
        mApiClient = apiClient;
    }

    public LiveData<List<Movie>> getMovies() {
        MutableLiveData<List<Movie>> data = new MutableLiveData<>();
        mApiClient.getMoviesInfo("popular", 1, BuildConfig.MOVIE_API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseObserver<List<Movie>>(mContext) {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        disposable = d;
                    }

                    @Override
                    public void onSuccess(List<Movie> movies) {
                        data.setValue(movies);
                    }
                });
        return data;
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        disposable.dispose();
    }
}
