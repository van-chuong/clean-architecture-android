package com.example.clean_chitecture.data.repository

import com.example.clean_chitecture.data.source.BuildingDataSource
import com.example.clean_chitecture.model.Building
import com.example.clean_chitecture.shared.scheduler.DataResult


class BuildingRepositoryImpl(
    private val local: BuildingDataSource.Local,
    private val remote: BuildingDataSource.Remote,
) : BuildingRepository {
    override suspend fun getAllBuilding(): DataResult<List<Building>> {
        return try {
            val response = remote.getAllBuildings()
            DataResult.Success(response)
        } catch (e: Exception) {
            DataResult.Error(e)
        }
    }

    override suspend fun getAllBuildingLocal(): DataResult<List<Building>> {
        return try {
            val data = local.getAllBuildings()
            DataResult.Success(data)
        } catch (e: Exception) {
            DataResult.Error(e)
        }
    }

    override suspend fun insertMultiBuildingsLocal(buildings: List<Building>): DataResult<Any> {
        return try {
            local.insertMultiBuildings(buildings)
            DataResult.Success(true)
        } catch (e: Exception) {
            DataResult.Error(e)
        }
    }
}