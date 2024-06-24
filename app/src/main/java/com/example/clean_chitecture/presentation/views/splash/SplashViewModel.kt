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
    private val buildingRepository: BuildingRepository,
) : BaseViewModel() {
    private val _completedTasks = MutableLiveData<Int>()
    val completedTasks: LiveData<Int> get() = _completedTasks

    init {
        _completedTasks.value = 0
        loadBuildings()
    }

    private fun loadBuildings() {
        launchTaskSync(
            onRequest = { buildingRepository.getAllBuilding() },
            onSuccess = {
                if (it.isNotEmpty()) {
                    insertMultiBuildings(it)
                }

                incrementCompletedTasks()
            },
            onError = { exception.value = it }
        )
    }

    private fun insertMultiBuildings(buildings: List<Building>) {
        launchTaskSync(
            onRequest = { buildingRepository.insertMultiBuildingsLocal(buildings) },
            onSuccess = { incrementCompletedTasks() },
            onError = { exception.value = it }
        )
    }

    private fun incrementCompletedTasks() {
        _completedTasks.value = (_completedTasks.value ?: 0) + 1
    }

    companion object {
        const val TOTAL_TASK = 2
    }
}