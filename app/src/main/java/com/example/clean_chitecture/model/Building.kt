package com.example.clean_chitecture.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.clean_chitecture.model.base.BaseResponse
import com.example.clean_chitecture.shared.utils.ConverterUntil
import com.google.gson.annotations.SerializedName
import io.appwrite.models.Document
import kotlinx.parcelize.Parcelize

@Entity(tableName = "buildings")
@Parcelize
data class Building(

    @SerializedName("\$id")
    @PrimaryKey
    val id: String,

    @SerializedName("projectID")
    val projectId: String? = "",

    @SerializedName("name")
    val name: String? = "",

    @SerializedName("endPointUrl")
    val endPointUrl: String? = "",

    @SerializedName("buildingDatabaseID")
    val buildingDatabaseId: String? = "",

    @SerializedName("userCollectionID")
    val userCollectionId: String? = "",

    @SerializedName("floorCollectionID")
    val floorCollectionId: String? = "",

    @SerializedName("apartmentColletionID")
    val apartmentCollectionId: String? = "",

    @SerializedName("roomCollectionID")
    val roomCollectionId: String? = "",

    @SerializedName("sensorCollectionID")
    val sensorCollectionId: String? = "",

    @SerializedName("userNotificationCollectionID")
    val userNotificationCollectionId: String? = "",

    @SerializedName("sensorNotificationCollectionID")
    val sensorNotificationCollectionId: String? = "",

    @SerializedName("notificationCollectionID")
    val notificationCollectionId: String? = "",

    @SerializedName("caseFireLocationCollectionID")
    val caseFireLocationCollectionId: String? = "",

    @SerializedName("cornerLocationBuilding")
    @TypeConverters(ConverterUntil::class)
    val cornerLocationBuilding: List<String>,


    @SerializedName("\$createdAt")
    val createdAt: String? = "",

    @SerializedName("\$updatedAt")
    val updatedAt: String? = "",
) : Parcelable {
    companion object : BaseResponse<Building, Map<String, Any>>() {
        override fun fromDocument(document: Document<Map<String, Any>>): Building {
            val data = document.data
            return Building(
                id = document.id,
                projectId = data["projectID"] as String,
                name = data["name"] as String,
                endPointUrl = data["endPointUrl"] as String,
                buildingDatabaseId = data["buildingDatabaseID"] as String,
                userCollectionId = data["userCollectionID"] as String,
                floorCollectionId = data["floorCollectionID"] as String,
                apartmentCollectionId = data["apartmentColletionID"] as String,
                roomCollectionId = data["roomCollectionID"] as String,
                sensorCollectionId = data["sensorCollectionID"] as String,
                userNotificationCollectionId = data["userNotificationCollectionID"] as String,
                sensorNotificationCollectionId = data["sensorNotificationCollectionID"] as String,
                notificationCollectionId = data["notificationCollectionID"] as String,
                caseFireLocationCollectionId = data["caseFireLocationCollectionID"] as String,
                cornerLocationBuilding = data["cornerLocationBuilding"] as List<String>,
                createdAt = document.createdAt,
                updatedAt = document.updatedAt
            )
        }
    }
}
