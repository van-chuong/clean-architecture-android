package com.example.clean_chitecture.shared.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun Context.checkNetworkConnection(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
    return networkInfo?.isConnected ?: false
}