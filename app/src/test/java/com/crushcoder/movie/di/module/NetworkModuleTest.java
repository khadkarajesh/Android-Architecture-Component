package com.crushcoder.movie.di.module;

import com.crushcoder.movie.service.ApiClient;
import com.crushcoder.movie.service.ApiService;
import com.google.gson.Gson;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModuleTest {

    @Provides
    @Singleton
    public Gson providesGson() {
        return Mockito.mock(Gson.class);
    }


    @Provides
    @Singleton
    public GsonConverterFactory providesGsonConverterFactory() {
        return Mockito.mock(GsonConverterFactory.class);
    }


    @Provides
    @Singleton
    public HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        return Mockito.mock(HttpLoggingInterceptor.class);
    }


    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient() {
        return Mockito.mock(OkHttpClient.class);
    }


    @Provides
    @Singleton
    public Retrofit providesRetrofit() {
        return Mockito.mock(Retrofit.class);
    }

    @Provides
    @Singleton
    public ApiService provideService() {
        return Mockito.mock(ApiService.class);
    }


    @Provides
    @Singleton
    public ApiClient provideApiClient() {
        return Mockito.mock(ApiClient.class);
    }

}