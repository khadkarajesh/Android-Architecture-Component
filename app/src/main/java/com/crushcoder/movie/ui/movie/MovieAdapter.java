package com.crushcoder.movie.ui.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crushcoder.movie.service.response.Movie;
import com.crushcoder.movie.R;

import java.util.List;

import timber.log.Timber;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final Context mContext;
    private List<Movie> mMovies;

    public MovieAdapter(Context mContext, List<Movie> movies) {
        this.mContext = mContext;
        this.mMovies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_movie_adapter_single_movie_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Timber.d("movies " + mMovies.get(position).title);
        holder.mTvTitle.setText(mMovies.get(position).title);
        Glide.with(mContext).load("http://image.tmdb.org/t/p/w342/" + mMovies.get(position).poster_path).into(holder.mIvPoster);
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
        TextView mTvTitle;
        ImageView mIvPoster;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.movie_adapter_tv_title);
            mIvPoster = itemView.findViewById(R.id.movie_adapter_iv_poster);
        }
    }
}
