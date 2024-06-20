package com.example.clean_chitecture.presentation.views.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.clean_chitecture.data.repository.BuildingRepository
import com.example.clean_chitecture.data.repository.MovieRepository
import com.example.clean_chitecture.model.Building
import com.example.clean_chitecture.model.Movie
import com.example.clean_chitecture.presentation.base.BaseViewModel

class SplashViewModel(
    private val movieRepository: MovieRepository,
    private val buildingRepository: BuildingRepository,
) : BaseViewModel() {
    private val _movies = MutableLiveData<MutableList<Movie>>()
    val movies: LiveData<MutableList<Movie>> get() = _movies

    private val _loadingComplete = MutableLiveData<Boolean>()
    val loadingComplete: LiveData<Boolean> get() = _loadingComplete

    init {
        loadBuildings()
        loadBuildingsLocal()
    }

    private fun loadBuildings() {
        launchTaskSync(
            onRequest = { buildingRepository.getAllBuilding() },
            onSuccess = {
                Log.d("Dataaaaa Remote", it.toString())
                if (it.isNotEmpty()) {
                    insertMultiBuildings(it)
                }

            },
            onError = { exception.value = it }
        )
    }

    private fun loadBuildingsLocal() {
        launchTaskSync(
            onRequest = { buildingRepository.getAllBuildingLocal() },
            onSuccess = { Log.d("Dataaaaa Local", it.toString()) },
            onError = { exception.value = it }
        )
    }

    private fun insertMultiBuildings(buildings: List<Building>) {
        launchTaskSync(
            onRequest = { buildingRepository.insertMultiBuildingsLocal(buildings) },
            onSuccess = {},
            onError = { exception.value = it }
        )
    }
}