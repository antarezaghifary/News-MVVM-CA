package com.needcode.news_mvvm_ca.data.source.network

import com.needcode.news_mvvm_ca.data.model.NewsListsModel
import retrofit2.Response

class ApiServiceImpl : ApiService {
    override suspend fun getPagedNews(page: Int, pageSize: Int): Response<NewsListsModel> {
        return NetworkConfig.api().getPagedNews(page, pageSize)
    }
}