package com.crushcoder.moviesmvvm.architecturecomponent;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.crushcoder.moviesmvvm.Movie;
import com.crushcoder.moviesmvvm.rest.ApiService;

import java.util.List;

import javax.inject.Inject;


public class MovieModel extends ViewModel {
    private Activity activity;

    @Inject
    DataRepository mDataRepository;

    public LiveData<List<Movie>> getMovies() {
        return new DataRepository(new ApiService().get()).getMovies();
    }
}
