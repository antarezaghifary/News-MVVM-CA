package com.needcode.news_mvvm_ca.presenter.list.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.needcode.news_mvvm_ca.data.model.NewsModel
import com.needcode.news_mvvm_ca.domain.usecase.ListUseCase
import com.needcode.news_mvvm_ca.external.LoadingState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


/**
 * akan mengirim event ke useCase untuk melakukan pengambilan data dari API maupun dari LOCAL
 * melalui function useCase.getPagedNews(). dan membuat coroutines baru sehingga tidak terjadi
 * blocking saat useCase melakukan request ke Entity. delay dapat kalian atur sesuka hati untuk testing.
 */


class NewsDataSource(private val scope: CoroutineScope, private val useCase: ListUseCase) :
    PageKeyedDataSource<Int, NewsModel>() {

    var state: MutableLiveData<LoadingState> = MutableLiveData()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, NewsModel>
    ) {
        scope.launch(Dispatchers.IO) {
//            delay(1000)
            state.postValue(LoadingState.LOADING)
            val res = async { useCase.getPagedNews(1, params.requestedLoadSize) }
            val list = res.await()?.toMutableList()
            if (list != null) {
                callback.onResult(list, null, 2)
            }
            state.postValue(LoadingState.DONE)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, NewsModel>) {
        scope.launch(Dispatchers.IO) {
//            delay(1000)
            state.postValue(LoadingState.LOADING)
            val res = async { useCase.getPagedNews(params.key, params.requestedLoadSize) }
            val list = res.await()?.toMutableList()
            if (list != null) {
                callback.onResult(list, params.key + 1)
            }
            state.postValue(LoadingState.DONE)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, NewsModel>) {
    }
}