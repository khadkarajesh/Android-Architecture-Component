package com.crushcoder.moviesmvvm;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;


public class MovieLiveData extends LiveData<List<Movie>> {
    private Context mContext;

    public MovieLiveData(Context context) {
        this.mContext = context;
        setValue(new ArrayList<>());
    }

    public void getMovies() {
//        ApiService.INSTANCE.get()
//                .getMoviesInfo("popular", 1, BuildConfig.MOVIE_API_KEY)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new BaseObserver<List<Movie>>(mContext) {
//                    @Override
//                    public void onSuccess(List<Movie> movies) {
//                        Timber.d("data list " + movies.size());
//                    }
//                });

    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
