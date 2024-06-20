package com.example.clean_chitecture.data.source.remote.appwrite

import android.content.Context
import com.example.clean_chitecture.data.ConstantData.GENERAL_POINT_URL
import com.example.clean_chitecture.data.ConstantData.GENERAL_PROJECT_ID
import io.appwrite.Client
import io.appwrite.services.Account
import io.appwrite.services.Databases

class AppwriteManager(private val context: Context) {
    private lateinit var client: Client
    private lateinit var account: Account
    private lateinit var database: Databases

    init {
        initClient(GENERAL_POINT_URL, GENERAL_PROJECT_ID)
    }

    fun initClient(endpoint: String, projectId: String) {
        client = Client(context)
            .setEndpoint(endpoint)
            .setProject(projectId)
            .setSelfSigned(true)

        account = Account(client)
        database = Databases(client)
    }

    fun getAccount(): Account {
        return account
    }

    fun getDatabase(): Databases {
        return database
    }
}
