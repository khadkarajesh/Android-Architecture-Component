package com.crushcoder.movie.ui.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crushcoder.movie.R;
import com.crushcoder.movie.databinding.ActivityMovieListBinding;
import com.crushcoder.movie.ui.base.BaseActivity;

import java.util.ArrayList;

import dagger.android.AndroidInjection;

public class MovieActivity extends BaseActivity<MovieViewModel, ActivityMovieListBinding> {
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        initializeAdapter();
        mViewModel.getMovies().observe(this, movies -> movieAdapter.addMovies(movies));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_movie_list;
    }

    private void initializeAdapter() {
        recyclerView = findViewById(R.id.movie_rv_movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(movieAdapter);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, MovieActivity.class);
        context.startActivity(intent);
    }
}
