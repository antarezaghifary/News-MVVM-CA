package com.needcode.githubuserapp.data.datasource.list

import com.needcode.githubuserapp.data.model.NewsListsModel
import com.needcode.githubuserapp.data.source.network.ApiServiceImpl
import com.needcode.githubuserapp.data.util.DataNotAvailableException
import com.needcode.githubuserapp.data.util.DataState
import javax.inject.Inject

class ListRemoteDataSource @Inject constructor(private val apiService: ApiServiceImpl) :
    ListDataSource.Remote {
    override suspend fun getPagedList(page: Int, pageSize: Int): DataState<NewsListsModel?>? {
        val res = apiService.getPagedNews(page, pageSize)
        return if (res.isSuccessful) {
            DataState.Success(res.body())
        } else
            DataState.Error(DataNotAvailableException())
    }
}