package com.crushcoder.moviesmvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.crushcoder.moviesmvvm.architecturecomponent.MovieListActivity;

import dagger.android.AndroidInjection;

public class MovieActivity extends AppCompatActivity {
    private MovieViewModel movieViewModel;
    private MovieLiveData movieLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_movie);

        MovieListActivity.start(this);

//        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
//        movieLiveData = new MovieLiveData(this);
//        movieLiveData.getMovies();
//        movieLiveData.observe(this, movies -> Timber.d("" + movies.size()));
    }
}
