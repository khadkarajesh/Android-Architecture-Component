package com.crushcoder.moviesmvvm.architecturecomponent;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crushcoder.moviesmvvm.R;
import com.crushcoder.moviesmvvm.rest.ApiClient;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MovieListActivity extends AppCompatActivity {
    //MovieModel movieModel;
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;

    MovieModel movieModel;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Inject
    ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerView = findViewById(R.id.movie_rv_movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(movieAdapter);

        movieModel = ViewModelProviders.of(this, mViewModelFactory).get(MovieModel.class);

        movieModel.getMovies().observe(this, movies -> movieAdapter.addMovies(movies));
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, MovieListActivity.class);
        context.startActivity(intent);
    }
}
