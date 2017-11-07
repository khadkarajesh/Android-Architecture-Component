package com.crushcoder.movie.di;


import com.crushcoder.movie.MovieApplication;

import dagger.Subcomponent;


@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    void inject(MovieApplication application);
}
