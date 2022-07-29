package com.needcode.githubuserapp.data.repository

import android.util.Log
import com.needcode.githubuserapp.data.datasource.list.ListDataSource
import com.needcode.githubuserapp.data.model.NewsModel
import com.needcode.githubuserapp.data.util.DataState
import com.needcode.githubuserapp.data.util.Mapper
import com.needcode.githubuserapp.domain.repository.ListRepository
import java.net.UnknownHostException
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val local: ListDataSource.Local,
    private val remote: ListDataSource.Remote
) :
    ListRepository {
    override suspend fun getPagedNews(page: Int, pageSize: Int): List<NewsModel>? {
        return getLocalData(page, pageSize)
    }

    private suspend fun getLocalData(page: Int, pageSize: Int): List<NewsModel>? {
        Log.e("LIST REPOSITORY", "GETTING FROM DB")
        return when (val res = local.getPagedList(page, pageSize)) {
            is DataState.Success -> {
                Log.e("LIST REPOSITORY", "GETTING FROM DB SUCCESS")
                res.data?.newsModel
            }
            is DataState.Error -> {
                Log.e("LIST REPOSITORY", "GETTING FROM DB ERROR")
                getRemoteData(page, pageSize)
            }
            else -> emptyList()
        }
    }

    private suspend fun getRemoteData(page: Int, pageSize: Int): List<NewsModel>? {
        Log.e("LIST REPOSITORY", "GETTING FROM API")
        return try {
            val res = remote.getPagedList(page, pageSize)
            if (res is DataState.Success) {
                Log.e("LIST REPOSITORY", "GETTING FROM API SUCCESS")
                local.savePagedList(Mapper.toLocalList(res.data?.newsModel))
                res.data?.newsModel
            } else {
                Log.e("LIST REPOSITORY", "GETTING FROM API ERROR")
                emptyList()
            }
        } catch (e: UnknownHostException) {
            e.printStackTrace()
            emptyList()
        }
    }
}