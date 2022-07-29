package com.needcode.githubuserapp.data.datasource.list

import com.needcode.githubuserapp.data.model.NewsListsModel
import com.needcode.githubuserapp.data.source.local.entity.LocalNewsModel
import com.needcode.githubuserapp.data.util.DataState

interface ListDataSource {
    interface Remote {
        suspend fun getPagedList(page: Int, pageSize: Int): DataState<NewsListsModel?>?
    }

    interface Local : Remote {
        suspend fun savePagedList(list: List<LocalNewsModel>)
    }
}