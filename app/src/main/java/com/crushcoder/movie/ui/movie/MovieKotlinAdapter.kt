package com.crushcoder.movie.ui.movie

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MovieKotlinAdapter(fragmentManager: FragmentManager, fragments: List<Fragment>, title: List<String>) : FragmentPagerAdapter(fragmentManager) {
    val fragments: List<Fragment>? = fragments
    val title: List<String>? = title
    override fun getItem(position: Int): Fragment {
        return fragments!![position]
    }

    override fun getCount(): Int {
        return fragments!!.size
    }

    override fun getPageTitle(position: Int): String? {
        return title?.get(position)
    }

}
