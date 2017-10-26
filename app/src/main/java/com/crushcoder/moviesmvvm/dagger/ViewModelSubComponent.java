package com.crushcoder.moviesmvvm.dagger;


import com.crushcoder.moviesmvvm.architecturecomponent.MovieModel;

import dagger.Subcomponent;


@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    MovieModel movieViewModel();
}
