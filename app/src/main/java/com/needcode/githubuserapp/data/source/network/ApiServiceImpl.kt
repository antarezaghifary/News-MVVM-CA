package com.needcode.githubuserapp.data.source.network

import com.needcode.githubuserapp.data.model.NewsListsModel
import retrofit2.Response

class ApiServiceImpl : ApiService {
    override suspend fun getPagedNews(page: Int, pageSize: Int): Response<NewsListsModel> {
        return NetworkConfig.api().getPagedNews(page, pageSize)
    }
}