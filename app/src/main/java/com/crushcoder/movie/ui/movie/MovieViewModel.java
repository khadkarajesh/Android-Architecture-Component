package com.crushcoder.movie.ui.movie;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.crushcoder.movie.BuildConfig;
import com.crushcoder.movie.service.ApiClient;
import com.crushcoder.movie.service.response.Movie;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MovieViewModel extends ViewModel {
    ApiClient apiClient;
    MutableLiveData<List<Movie>> listLiveData = new MutableLiveData<>();

    @Inject
    public MovieViewModel(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public LiveData<List<Movie>> getMovies() {
        apiClient.getMoviesInfo("popular", 1, BuildConfig.MOVIE_API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Movie>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        listLiveData.setValue(movies);
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
}
