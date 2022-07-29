package com.needcode.githubuserapp.data.source.network

import com.needcode.githubuserapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkConfig {
    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"
        fun api(): ApiService {
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.NONE
            }
            val client = OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(logging)
                .connectTimeout(3000L, TimeUnit.SECONDS)
                .readTimeout(3000L, TimeUnit.SECONDS)
                .writeTimeout(3000L, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}