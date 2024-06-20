package com.example.clean_chitecture.data.source.remote

import com.example.clean_chitecture.data.ConstantData.GENERAL_BUILDING_COLLECTION_ID
import com.example.clean_chitecture.data.ConstantData.GENERAL_DATABASE_ID
import com.example.clean_chitecture.data.source.BuildingDataSource
import com.example.clean_chitecture.data.source.remote.appwrite.AppwriteManager
import com.example.clean_chitecture.model.Building

class BuildingRemoteImpl(
    private val appwriteManager: AppwriteManager,
) : BuildingDataSource.Remote {
    private val database = appwriteManager.getDatabase()

    override suspend fun getAllBuildings(): List<Building> =
        Building.fromDocumentList(
            database.listDocuments(
                databaseId = GENERAL_DATABASE_ID,
                collectionId = GENERAL_BUILDING_COLLECTION_ID,
            ).documents
        )

    override suspend fun getBuildingById(id: String): Building? = null

    override suspend fun insertBuilding(building: Building) = Unit

    override suspend fun deleteBuilding(building: Building) = Unit

    override suspend fun deleteAllBuildings() = Unit
}