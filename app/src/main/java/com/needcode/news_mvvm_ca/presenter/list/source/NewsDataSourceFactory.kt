package com.needcode.news_mvvm_ca.presenter.list.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.needcode.news_mvvm_ca.data.model.NewsModel
import com.needcode.news_mvvm_ca.domain.usecase.ListUseCase
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