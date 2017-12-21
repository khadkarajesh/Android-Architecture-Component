package com.crushcoder.movie.ui.movie;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crushcoder.movie.BuildConfig
import com.crushcoder.movie.R
import com.crushcoder.movie.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = layoutInflater.inflate(R.layout.fragment_movie, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiService = ApiService.create()
        apiService.getMoviesInfo("popular", 1, BuildConfig.MOVIE_API_KEY)
                .enqueue(object : Callback<List<Movie>> {
                    override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?) {
                        Log.d("value", "value")
                    }

                    override fun onFailure(call: Call<List<Movie>>?, t: Throwable?) {
                        Log.d("error", "error" + t!!.localizedMessage)
                    }
                })
    }
}
