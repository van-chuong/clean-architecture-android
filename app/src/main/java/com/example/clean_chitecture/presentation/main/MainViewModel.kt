package com.example.clean_chitecture.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.clean_chitecture.presentation.base.BaseViewModel
import com.example.clean_chitecture.model.MovieItem
import com.example.clean_chitecture.model.MovieItemMapper
import com.example.domain.usecase.movie.GetMovieUseCase

class MainViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val movieItemMapper: MovieItemMapper
) : BaseViewModel() {

    private val _movies = MutableLiveData<List<MovieItem>>()
    val movies: LiveData<List<MovieItem>> get() = _movies

    fun loadMovies(page: Int) {

        launchTaskSync(
            onRequest = { getMovieUseCase.createObservable(GetMovieUseCase.Params(page)) },
            onSuccess = { movieList ->
                val movieItems = movieList.map { movieItemMapper.mapToPresentation(it) }
                _movies.postValue(movieItems)
            },
            onError = { exception ->
                this.exception.postValue(exception)
                Log.d("Dataaaaa", "${exception.message}")
            }
        )
    }
}
