package com.crushcoder.moviesmvvm.dagger;


import android.app.Application;
import android.content.Context;

import com.crushcoder.moviesmvvm.architecturecomponent.DataRepository;
import com.crushcoder.moviesmvvm.rest.ApiClient;
import com.crushcoder.moviesmvvm.rest.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = MovieActivityModule.class)
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    ApiClient provideApiClient() {
        return new ApiService().get();
    }

    @Provides
    @Singleton
    DataRepository provideDataRepository(ApiClient apiClient) {
        return new DataRepository(apiClient);
    }
}
