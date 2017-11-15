package com.crushcoder.movie.service;


import com.crushcoder.movie.BuildConfig;
import com.crushcoder.movie.service.response.Movie;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ApiClient {
    private ApiService service;

    @Inject
    public ApiClient(ApiService apiService) {
        this.service = apiService;
    }

    public Observable<List<Movie>> getMovies(String categories, int page) {
        return service.getMoviesInfo(categories, page, BuildConfig.MOVIE_API_KEY).toObservable();
    }
}

