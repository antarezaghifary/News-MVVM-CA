package com.needcode.news_mvvm_ca.domain.usecase

import android.util.Log
import com.needcode.news_mvvm_ca.data.model.NewsModel
import com.needcode.news_mvvm_ca.domain.repository.ListRepository
import javax.inject.Inject


/**
 * berfungsi sebagai jembatan antara Presenter dan Entity dan melakukan perubahan data jika diperlukan
 */

class ListUseCase @Inject constructor(private val repository: ListRepository) {
    suspend fun getPagedNews(page: Int, pageSize: Int): List<NewsModel>? {
        Log.e("USECASE", "GETTING DATA FROM REPO")
        return repository.getPagedNews(page, pageSize)
    }
}