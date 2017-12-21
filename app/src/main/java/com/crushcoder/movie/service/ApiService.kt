package com.crushcoder.movie.service

import com.crushcoder.movie.ui.movie.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("3/movie/{categories}")
    fun getMoviesInfo(@Path("categories") categories: String,
                      @Query("page") page: Int,
                      @Query("api_key") apiKey: String): Call<List<Movie>>

    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://api.themoviedb.org/")
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}

