package com.needcode.news_mvvm_ca.data.datasource.list

import com.needcode.news_mvvm_ca.data.model.NewsListsModel
import com.needcode.news_mvvm_ca.data.source.local.dao.ListDao
import com.needcode.news_mvvm_ca.data.source.local.entity.LocalNewsModel
import com.needcode.news_mvvm_ca.data.util.DataNotAvailableException
import com.needcode.news_mvvm_ca.data.util.DataState
import com.needcode.news_mvvm_ca.data.util.Mapper
import javax.inject.Inject

class ListLocalDataSource @Inject constructor(private val dao: ListDao) : ListDataSource.Local {
    override suspend fun savePagedList(list: List<LocalNewsModel>) {
        return dao.insertAllNews(list)
    }

    override suspend fun getPagedList(page: Int, pageSize: Int): DataState<NewsListsModel?>? {
        val maxPages = (dao.getPagingCount() ?: 0) / pageSize
        return if (page < maxPages) {
            val res = dao.getPagedNews(page, pageSize)
            return if (res.isNotEmpty()) {
                DataState.Success(NewsListsModel(Mapper.toRemoteList(res)))
            } else
                DataState.Error(DataNotAvailableException())
        } else DataState.Error(DataNotAvailableException())
    }
}