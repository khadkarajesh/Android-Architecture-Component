package com.crushcoder.movie.ui.movie;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.crushcoder.movie.R;
import com.crushcoder.movie.databinding.ViewMovieAdapterSingleMovieLayoutBinding;
import com.crushcoder.movie.service.response.Movie;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final Context mContext;
    private List<Movie> mMovies;

    public MovieAdapter(Context mContext, List<Movie> movies) {
        this.mContext = mContext;
        this.mMovies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewMovieAdapterSingleMovieLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.view_movie_adapter_single_movie_layout,
                parent,
                false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void addMovies(List<Movie> movies) {
        this.mMovies.clear();
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ViewMovieAdapterSingleMovieLayoutBinding mBinding;

        public ViewHolder(ViewMovieAdapterSingleMovieLayoutBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Movie movie) {
            mBinding.setMovie(movie);
            mBinding.executePendingBindings();
        }
    }


    @BindingAdapter({"android:src"})
    public static void showPoster(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load("http://image.tmdb.org/t/p/w342/" + url).into(imageView);
    }
}
