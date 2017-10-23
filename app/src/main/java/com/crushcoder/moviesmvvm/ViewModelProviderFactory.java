package com.crushcoder.moviesmvvm;

import android.arch.lifecycle.*;
import android.arch.lifecycle.ViewModel;


public class ViewModelProviderFactory<V> implements ViewModelProvider.Factory {
    private V viewModel;

    public ViewModelProviderFactory(V viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(viewModel.getClass())) {
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
