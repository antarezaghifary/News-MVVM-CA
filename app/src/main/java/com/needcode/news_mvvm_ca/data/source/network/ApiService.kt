package com.needcode.news_mvvm_ca.data.source.network

import com.needcode.news_mvvm_ca.data.model.NewsListsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything?q=sports&apiKey=b0b90bff982042f6a8e03fb6430dbc50")
    suspend fun getPagedNews(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Response<NewsListsModel>
}