package com.crushcoder.movie.di.module;

import com.crushcoder.movie.di.ViewModelModule;
import com.crushcoder.movie.service.ApiClient;
import com.crushcoder.movie.service.ApiService;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelModule.class})
public class NetworkModule {
    @Provides
    ApiClient provideApi() {
        return new ApiService().get();
    }
}
