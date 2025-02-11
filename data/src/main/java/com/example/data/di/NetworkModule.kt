package com.example.data.di

import com.example.data.ConstantData
import com.example.data.di.Properties.CONNECTION_TIMEOUT
import com.example.data.source.remote.api.MovieApi
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule: Module = module {
    single { createRetrofit() }
    single { createApi() }
}

object Properties {
    const val CONNECTION_TIMEOUT: Long = 60
}

fun createRetrofit(): Retrofit {
    val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
    httpClient.addInterceptor { chain ->
        var request = chain.request()
        val url = request
            .url
            .newBuilder().addQueryParameter(ConstantData.PARAM_KEY, ConstantData.KEY)
            .build()
        request = request.newBuilder().url(url).build()
        chain.proceed(request)
    }
    httpClient.addInterceptor(createLoggingInterceptor())
    httpClient.apply {
        readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
    }

    val gson = GsonBuilder().create()

    return Retrofit.Builder().baseUrl(ConstantData.END_POINT_URL)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(httpClient.build())
        .build()
}

fun createApi(): MovieApi = createRetrofit().create(MovieApi::class.java)

fun createLoggingInterceptor(): Interceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}

