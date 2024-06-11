package com.example.clean_chitecture.presentation.views.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.clean_chitecture.data.repository.MovieRepository
import com.example.clean_chitecture.model.Movie
import com.example.clean_chitecture.presentation.base.BaseViewModel

class SplashViewModel(private val movieRepository: MovieRepository) : BaseViewModel() {
    private val _movies = MutableLiveData<MutableList<Movie>>()
    val movies: LiveData<MutableList<Movie>> get() = _movies

    private val _loadingComplete = MutableLiveData<Boolean>()
    val loadingComplete: LiveData<Boolean> get() = _loadingComplete

    init {
        loadAllData()
        Log.d("Dataaaaa", "Init")
    }

    private fun loadAllData() {
        loadMovies(1)
    }

    fun loadMovies(page: Int) {
        launchTaskSync(
            onRequest = { movieRepository.getPopularMovies(page) },
            onSuccess = { _movies.value = it.results.toMutableList() },
            onError = { exception.value = it }
        )
    }
}