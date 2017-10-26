package com.crushcoder.moviesmvvm.dagger;

import com.crushcoder.moviesmvvm.rest.ApiClient;
import com.crushcoder.moviesmvvm.rest.ApiService;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelModule.class})
public class NetworkModule {
    @Provides
    ApiClient provideApi() {
        return new ApiService().get();
    }
}
