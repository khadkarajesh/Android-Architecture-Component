package com.crushcoder.movie.ui.adapter;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.crushcoder.movie.BR;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                getLayoutId(viewType)
                , parent,
                false);

        return new BaseViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(getItemAtPosition(position));
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding viewDataBinding;

        public BaseViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
        }

        public void bind(Object object) {
            viewDataBinding.setVariable(BR.obj, object);
            viewDataBinding.executePendingBindings();
        }
    }

    public abstract int getLayoutId(int viewType);

    public abstract Object getItemAtPosition(int position);
}
