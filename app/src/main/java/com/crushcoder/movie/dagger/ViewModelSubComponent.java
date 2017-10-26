package com.crushcoder.movie.dagger;


import com.crushcoder.movie.architecturecomponent.MovieModel;

import dagger.Subcomponent;


@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    MovieModel movieViewModel();
}
