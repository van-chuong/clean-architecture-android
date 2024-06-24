package com.example.clean_chitecture.data.repository

import com.example.clean_chitecture.model.Building
import com.example.clean_chitecture.shared.scheduler.DataResult

interface BuildingRepository {
    suspend fun getAllBuilding(): DataResult<List<Building>>

    suspend fun getAllBuildingLocal(): DataResult<List<Building>>

    suspend fun insertMultiBuildingsLocal(buildings: List<Building>): DataResult<Any>
}