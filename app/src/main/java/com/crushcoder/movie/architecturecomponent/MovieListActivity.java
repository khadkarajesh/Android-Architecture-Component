package com.crushcoder.movie.architecturecomponent;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crushcoder.movie.R;
import com.crushcoder.movie.rest.ApiClient;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

public class MovieListActivity extends AppCompatActivity implements HasFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    //MovieModel movieModel;
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;

    @Inject
    ApiClient apiClient;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    MovieModel movieModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerView = findViewById(R.id.movie_rv_movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(movieAdapter);


        movieModel = ViewModelProviders.of(this, viewModelFactory).get(MovieModel.class);
        movieModel.getMovies().observe(this, movies -> movieAdapter.addMovies(movies));
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, MovieListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
