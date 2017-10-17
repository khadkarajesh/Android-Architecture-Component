package com.crushcoder.moviesmvvm.rest;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public enum ApiService {
    INSTANCE;
    private final String BASE_URL = "http://api.themoviedb.org/";
    private Retrofit retrofit;
    private ApiClient mApi;

    ApiService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(getLogger())
                .build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(new UnwrapConverterFactory(GsonConverterFactory.create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApi = retrofit.create(ApiClient.class);
    }

    public ApiClient get() {
        return mApi;
    }

    public HttpLoggingInterceptor getLogger() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

}

