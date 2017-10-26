package com.crushcoder.moviesmvvm.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crushcoder.moviesmvvm.BuildConfig;
import com.crushcoder.moviesmvvm.R;
import com.crushcoder.moviesmvvm.rest.ApiClient;
import com.crushcoder.moviesmvvm.rest.ApiResponse;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class MovieFragment extends Fragment implements HasFragmentInjector {
    DispatchingAndroidInjector<Fragment> androidInjector;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Inject
    ApiClient apiClient;

    @Override
    public void onAttach(Context context) {
        AndroidInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("apiClient " + apiClient);
        apiClient.getMovies("popular", 1, BuildConfig.MOVIE_API_KEY)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<ApiResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiResponse apiResponse) {
                        Timber.d("data " + apiResponse);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public AndroidInjector<android.app.Fragment> fragmentInjector() {
        return androidInjector;
    }
}
