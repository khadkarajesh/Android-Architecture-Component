package com.crushcoder.movie.service;


import com.crushcoder.movie.service.response.Movie;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("3/movie/{categories}")
    Single<List<Movie>> getMoviesInfo(@Path("categories") String categories,
                                      @Query("page") int page,
                                      @Query("api_key") String apiKey);
}
