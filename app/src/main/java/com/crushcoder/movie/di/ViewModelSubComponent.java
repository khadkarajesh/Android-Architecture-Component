package com.crushcoder.movie.di;


import com.crushcoder.movie.ui.movie.MovieViewModel;

import dagger.Subcomponent;


@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    MovieViewModel movieViewModel();
}
