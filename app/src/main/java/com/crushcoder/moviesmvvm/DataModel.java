package com.crushcoder.moviesmvvm;


import java.util.List;

import io.reactivex.Observable;

public class DataModel {
    public Observable<List<Movie>> getMovies() {
        return ApiService.INSTANCE.get().getMoviesInfo("popular", 1, BuildConfig.MOVIE_API_KEY);
    }
}
