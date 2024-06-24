package com.example.clean_chitecture.presentation.views.building

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.clean_chitecture.data.repository.BuildingRepository
import com.example.clean_chitecture.data.repository.MainBuildingRepository
import com.example.clean_chitecture.model.Building
import com.example.clean_chitecture.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class SelectBuildingViewModel(
    private val buildingRepository: BuildingRepository,
    private val mainBuildingRepository: MainBuildingRepository,
) : BaseViewModel() {
    private val _buildings = MutableLiveData<MutableList<Building>>()
    val buildings: LiveData<MutableList<Building>> = _buildings

    private val _selectedBuilding = MutableLiveData<Building>()
    val selectedBuilding: LiveData<Building> = _selectedBuilding

    private val _saveMainBuildingStatus = MutableLiveData<Boolean>()
    val saveMainBuildingStatus: LiveData<Boolean> = _saveMainBuildingStatus

    fun setSelectedBuilding(building: Building) {
        _selectedBuilding.value = building
    }

    fun setSaveMainBuildingStatus(status: Boolean) {
        _saveMainBuildingStatus.value = status
    }

    init {
        loadBuildingsLocal()
    }

    private fun loadBuildingsLocal() {
        launchTaskSync(
            onRequest = { buildingRepository.getAllBuildingLocal() },
            onSuccess = { _buildings.value = it.toMutableList() },
            onError = { exception.value = it }
        )
    }

    fun saveMainBuilding() {
        viewModelScope.launch {
            runCatching {
                selectedBuilding.value?.let { building ->
                    mainBuildingRepository.projectId = building.projectId.toString()
                    mainBuildingRepository.name = building.name.toString()
                    mainBuildingRepository.endPointUrl = building.endPointUrl.toString()
                    mainBuildingRepository.buildingDatabaseId = building.buildingDatabaseId.toString()
                    mainBuildingRepository.userCollectionId = building.userCollectionId.toString()
                    mainBuildingRepository.floorCollectionId = building.floorCollectionId.toString()
                    mainBuildingRepository.apartmentCollectionId = building.apartmentCollectionId.toString()
                    mainBuildingRepository.roomCollectionId = building.roomCollectionId.toString()
                    mainBuildingRepository.sensorCollectionId = building.sensorCollectionId.toString()
                    mainBuildingRepository.userNotificationCollectionId = building.userNotificationCollectionId.toString()
                    mainBuildingRepository.sensorNotificationCollectionId = building.sensorNotificationCollectionId.toString()
                    mainBuildingRepository.notificationCollectionId = building.notificationCollectionId.toString()
                    mainBuildingRepository.caseFireLocationCollectionId = building.caseFireLocationCollectionId.toString()
                    mainBuildingRepository.cornerLocationBuilding = building.cornerLocationBuilding
                }
            }.onSuccess {
                _saveMainBuildingStatus.value = true
            }
        }
    }
}