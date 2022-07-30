package com.needcode.news_mvvm_ca.domain.repository

import com.needcode.news_mvvm_ca.data.model.NewsModel

interface ListRepository {
    suspend fun getPagedNews(page: Int, pageSize: Int): List<NewsModel>?
}