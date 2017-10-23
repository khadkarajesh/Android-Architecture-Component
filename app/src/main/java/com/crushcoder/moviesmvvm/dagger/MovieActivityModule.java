package com.crushcoder.moviesmvvm.dagger;

import android.arch.lifecycle.ViewModelProvider;

import com.crushcoder.moviesmvvm.ViewModelProviderFactory;
import com.crushcoder.moviesmvvm.architecturecomponent.MovieModel;

import dagger.Module;
import dagger.Provides;


@Module
public class MovieActivityModule {
    @Provides
    MovieModel provideMovieModel() {
        return new MovieModel();
    }

    @Provides
    ViewModelProvider.Factory movieModelProvider(MovieModel movieModel) {
        return new ViewModelProviderFactory<>(movieModel);
    }
}
