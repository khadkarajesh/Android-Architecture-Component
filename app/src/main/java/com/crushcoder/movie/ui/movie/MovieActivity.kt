package com.crushcoder.movie.ui.movie

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.crushcoder.movie.R


class MovieActivity : AppCompatActivity() {
    lateinit var tab: TabLayout
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        tab = findViewById(R.id.movie_tab_category)
        viewPager = findViewById(R.id.movie_vp_category)

        var fragments = ArrayList<Fragment>()
        fragments.add(MovieFragment())
        fragments.add(MovieFragment())
        fragments.add(MovieFragment())


        var titles = ArrayList<String>()
        titles.add("movies")
        titles.add("drama")
        titles.add("tv series")

        val adapter = MovieKotlinAdapter(supportFragmentManager, fragments, titles)
        viewPager.adapter = adapter
        tab.setupWithViewPager(viewPager)
    }
}
