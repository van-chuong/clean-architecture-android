package com.example.clean_chitecture.data.source.local

import android.content.Context
import android.preference.PreferenceManager
import com.example.clean_chitecture.data.source.MainBuildingDatasource
import com.google.gson.reflect.TypeToken
import io.appwrite.extensions.gson
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainBuildingLocalImpl(
    context: Context
) : MainBuildingDatasource.Local {

    private val pref = PreferenceManager.getDefaultSharedPreferences(context)

    override var projectId: String by StringProp("projectId", "")

    override var name: String by StringProp("name", "")

    override var endPointUrl: String by StringProp("endPointUrl", "")

    override var buildingDatabaseId: String by StringProp("buildingDatabaseId", "")

    override var userCollectionId: String by StringProp("userCollectionId", "")

    override var floorCollectionId: String by StringProp("floorCollectionId", "")

    override var apartmentCollectionId: String by StringProp("apartmentCollectionId", "")

    override var roomCollectionId: String by StringProp("roomCollectionId", "")

    override var sensorCollectionId: String by StringProp("sensorCollectionId", "")

    override var userNotificationCollectionId: String by StringProp("userNotificationCollectionId", "")

    override var sensorNotificationCollectionId: String by StringProp("sensorNotificationCollectionId", "")

    override var notificationCollectionId: String by StringProp("notificationCollectionId", "")

    override var caseFireLocationCollectionId: String by StringProp("caseFireLocationCollectionId", "")

    override var cornerLocationBuilding: List<String>
        get() {
            val json = pref.getString("cornerLocationBuilding", null)
            return if (json != null) {
                gson.fromJson(json, object : TypeToken<List<String>>() {}.type)
            } else {
                emptyList()
            }
        }
        set(value) {
            val json = gson.toJson(value)
            pref.edit().putString("cornerLocationBuilding", json).apply()
        }

    inner class IntProp(private val key: String, defaultValue: Int = 0) : ReadWriteProperty<Any, Int> {
        private var value: Int = pref.getInt(key, defaultValue)

        override fun getValue(thisRef: Any, property: KProperty<*>): Int = value

        override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
            pref.edit().putInt(key, value).apply()
            this.value = value
        }
    }

    inner class StringProp(private val key: String, defaultValue: String) : ReadWriteProperty<Any, String> {
        private var value: String = pref.getString(key, null) ?: defaultValue

        override fun getValue(thisRef: Any, property: KProperty<*>): String = value

        override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
            pref.edit().putString(key, value).apply()
            this.value = value
        }
    }
}