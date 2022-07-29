package com.needcode.githubuserapp.presenter.list.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.needcode.githubuserapp.data.model.NewsModel
import com.needcode.githubuserapp.domain.usecase.ListUseCase
import kotlinx.coroutines.CoroutineScope

/**
 * bertugas mengontrol beberapa datasource yang berbeda
 */


class NewsDataSourceFactory(private val scope: CoroutineScope, private val useCase: ListUseCase) :
    DataSource.Factory<Int, NewsModel>() {

    val newsDataSourceLiveData: MutableLiveData<NewsDataSource> = MutableLiveData()

    override fun create(): DataSource<Int, NewsModel> {
        val newsDataSource = NewsDataSource(scope, useCase)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}