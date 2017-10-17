package com.crushcoder.moviesmvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public class MovieActivity extends AppCompatActivity {
    private MovieViewModel movieViewModel;
    private MovieLiveData movieLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieLiveData = new MovieLiveData(this);
        movieLiveData.getMovies();
        movieLiveData.observe(this, movies -> Timber.d("" + movies.size()));
    }
}
