package com.crushcoder.moviesmvvm.dagger;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.crushcoder.moviesmvvm.ViewModelProviderFactory;
import com.crushcoder.moviesmvvm.architecturecomponent.MovieModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieModel.class)
    abstract ViewModel bindsMovieListViewModel(MovieModel movieListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
