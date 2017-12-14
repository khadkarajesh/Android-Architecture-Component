package com.crushcoder.movie.ui.movie;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crushcoder.movie.R;
import com.crushcoder.movie.TestObserver;
import com.crushcoder.movie.databinding.ActivityMovieListBinding;
import com.crushcoder.movie.ui.base.BaseViewModelActivity;

import java.util.ArrayList;

import dagger.android.AndroidInjection;
import timber.log.Timber;

public class MovieViewModelActivity extends BaseViewModelActivity<MovieViewModel, ActivityMovieListBinding> {
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        initializeAdapter();
        mViewModel.getMovies().observe(this, movies -> movieAdapter.addMovies(movies));

        getLifecycle().addObserver(new TestObserver());

        //test data
    }

    @Override
    public int getLayout() {
        return R.layout.activity_movie_list;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void showClick() {
        Timber.d("onCreate called");
    }

    private void initializeAdapter() {
        recyclerView = findViewById(R.id.movie_rv_movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(movieAdapter);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, MovieViewModelActivity.class);
        context.startActivity(intent);
    }
}
