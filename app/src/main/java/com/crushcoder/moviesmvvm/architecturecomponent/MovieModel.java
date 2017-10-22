package com.crushcoder.moviesmvvm.architecturecomponent;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.crushcoder.moviesmvvm.Movie;

import java.util.List;


public class MovieModel extends AndroidViewModel {
    private DataRepository mDataRepository;
    private Activity activity;

    public MovieModel(Application application) {
        super(application);
        //mDataRepository = new DataRepository(acti);
    }

    public void setContext(Activity activity) {
        this.activity = activity;
    }


    public LiveData<List<Movie>> getMovies() {
        return mDataRepository.getMovies();
    }
}
