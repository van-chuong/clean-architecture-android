package com.example.clean_chitecture.data.source.remote.appwrite

import android.content.Context
import io.appwrite.Client
import io.appwrite.models.Session
import io.appwrite.services.Account
import io.appwrite.services.Databases

class AppwriteManager(private val context: Context) {
    private var clients: MutableMap<String, Client> = mutableMapOf()
    private var accounts: MutableMap<String, Account> = mutableMapOf()
    private var databases: MutableMap<String, Databases> = mutableMapOf()

    private fun initClient(projectId: String) {
        val client = Client(context)
            .setEndpoint("https://[YOUR_APPWRITE_ENDPOINT]")
            .setProject(projectId)

        clients[projectId] = client
        accounts[projectId] = Account(client)
        databases[projectId] = Databases(client)
    }

    fun switchProject(projectId: String) {
        if (!clients.containsKey(projectId)) {
            initClient(projectId)
        }
    }

    fun getAccount(projectId: String): Account? {
        return accounts[projectId]
    }

    fun getDatabase(projectId: String): Databases? {
        return databases[projectId]
    }

    suspend fun onLogin(
        projectId: String,
        email: String,
        password: String,
    ): Session? {
        val account = accounts[projectId] ?: return null
        return account.createEmailPasswordSession(
            email,
            password,
        )
    }
}
