package com.crushcoder.movie.ui.movie;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.crushcoder.movie.R;
import com.crushcoder.movie.ui.adapter.MovieCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {
    private TabLayout mCategoryTab;
    private ViewPager mCategoryPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setupCategory();
    }

    private void setupCategory() {
        mCategoryTab = findViewById(R.id.movie_tab_category);
        mCategoryPager = findViewById(R.id.movie_vp_category);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(MoviesFragment.getInstance());
        fragments.add(MoviesFragment.getInstance());
        fragments.add(MoviesFragment.getInstance());
        fragments.add(MoviesFragment.getInstance());
        fragments.add(MoviesFragment.getInstance());
        //fragments.add(MoviesFragment.getInstance());

        List<String> titles = new ArrayList<>();
        titles.add("movies");
        titles.add("movies");
        titles.add("movies");
        titles.add("movies");
        titles.add("movies");


        MovieCategoryAdapter movieCategoryAdapter = new MovieCategoryAdapter(getSupportFragmentManager(), fragments, titles);
        mCategoryPager.setAdapter(movieCategoryAdapter);
        mCategoryTab.setupWithViewPager(mCategoryPager);
    }
}
