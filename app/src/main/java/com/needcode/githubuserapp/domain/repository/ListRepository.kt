package com.needcode.githubuserapp.domain.repository

import com.needcode.githubuserapp.data.model.NewsModel

interface ListRepository {
    suspend fun getPagedNews(page: Int, pageSize: Int): List<NewsModel>?
}