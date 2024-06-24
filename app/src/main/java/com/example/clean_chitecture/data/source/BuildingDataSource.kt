package com.example.clean_chitecture.data.source

import com.example.clean_chitecture.model.Building

interface BuildingDataSource {

    interface Local {
        suspend fun getAllBuildings(): List<Building>

        suspend fun getBuildingById(id: String): Building?

        suspend fun insertBuilding(building: Building)

        suspend fun insertMultiBuildings(buildings: List<Building>)

        suspend fun deleteBuilding(building: Building)

        suspend fun deleteAllBuildings()
    }

    interface Remote {
        suspend fun getAllBuildings(): List<Building>

        suspend fun getBuildingById(id: String): Building?

        suspend fun insertBuilding(building: Building)

        suspend fun deleteBuilding(building: Building)

        suspend fun deleteAllBuildings()
    }
}