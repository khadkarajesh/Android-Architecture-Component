package com.crushcoder.movie.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crushcoder.movie.R;
import com.crushcoder.movie.rest.ApiClient;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import timber.log.Timber;


public class MovieFragment extends Fragment {

    public MovieFragment() {
        // Required empty public constructor
    }

    @Inject
    ApiClient apiClient;

    @Override
    public void onAttach(Context context) {
        AndroidInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("apiClient " + apiClient);


    }
}
