package com.needcode.news_mvvm_ca.data.datasource.list

import com.needcode.news_mvvm_ca.data.model.NewsListsModel
import com.needcode.news_mvvm_ca.data.source.local.entity.LocalNewsModel
import com.needcode.news_mvvm_ca.data.util.DataState

interface ListDataSource {
    interface Remote {
        suspend fun getPagedList(page: Int, pageSize: Int): DataState<NewsListsModel?>?
    }

    interface Local : Remote {
        suspend fun savePagedList(list: List<LocalNewsModel>)
    }
}