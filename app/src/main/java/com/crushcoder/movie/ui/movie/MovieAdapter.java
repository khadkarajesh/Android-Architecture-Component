package com.crushcoder.movie.ui.movie;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.crushcoder.movie.R;
import com.crushcoder.movie.service.response.Movie;
import com.crushcoder.movie.ui.adapter.BaseAdapter;

import java.util.List;


public class MovieAdapter extends BaseAdapter {
    private final Context mContext;
    private List<Movie> mMovies;

    public MovieAdapter(Context mContext, List<Movie> movies) {
        this.mContext = mContext;
        this.mMovies = movies;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.view_movie_adapter_single_movie_layout;
    }

    @Override
    public Object getItemAtPosition(int position) {
        return mMovies.get(position);
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

    @BindingAdapter({"android:src"})
    public static void showPoster(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load("http://image.tmdb.org/t/p/w342/" + url).into(imageView);
    }
}
