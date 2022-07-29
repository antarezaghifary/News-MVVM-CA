package com.needcode.githubuserapp.presenter.list.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.needcode.githubuserapp.data.model.NewsModel
import com.needcode.githubuserapp.domain.usecase.ListUseCase
import com.needcode.githubuserapp.external.LoadingState
import com.needcode.githubuserapp.presenter.list.source.NewsDataSource
import com.needcode.githubuserapp.presenter.list.source.NewsDataSourceFactory
import javax.inject.Inject


/**
 * variable DataSourceFactory dan di function startPaging kita membuat config dan coroutine Scope
 * untuk dikirim sebagai parameters di DataSourceFactory. Setelah itu buat Livedata yang akan dikirim
 * ke Recyclerview berupa PagedList. dan function getLoadingState jika diperlukan
 */


class MainActivityViewModel @Inject constructor(private val useCase: ListUseCase) : ViewModel() {

    var dataSourceFactory: NewsDataSourceFactory? = null
    var list: LiveData<PagedList<NewsModel>>? = null

    fun startPaging() {
        Log.e("VIEWMODEL", "GETTING FROM USECASE")
        val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()
        dataSourceFactory = NewsDataSourceFactory(viewModelScope, useCase)

        if (dataSourceFactory != null)
            list = LivePagedListBuilder(dataSourceFactory!!, config).build()
    }

    fun getLoadingState(): LiveData<LoadingState>? {
        return if (dataSourceFactory != null)
            Transformations.switchMap(
                dataSourceFactory!!.newsDataSourceLiveData,
                NewsDataSource::state
            )
        else
            null
    }
}