package com.crushcoder.moviesmvvm.rest;


import com.crushcoder.moviesmvvm.Movie;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("3/movie/{categories}")
    Observable<List<Movie>> getMoviesInfo(@Path("categories") String categories, @Query("page") int page, @Query("api_key") String apiKey);

    @GET("3/movie/{categories}")
    Observable<ApiResponse> getMovies(@Path("categories") String categories, @Query("page") int page, @Query("api_key") String apiKey);

//    @GET("3/movie/{id}/reviews")
//    Observable<MovieComments> getComments(@Path("id") int id, @Query("api_key") String apiKey);
//
//    @GET("3/movie/{id}/videos")
//    Observable<MovieTrailerInfo> getMovieTrailer(@Path("id") int id, @Query("api_key") String apiKey);
}
