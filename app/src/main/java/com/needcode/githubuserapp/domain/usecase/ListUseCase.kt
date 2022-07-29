package com.needcode.githubuserapp.domain.usecase

import android.util.Log
import com.needcode.githubuserapp.data.model.NewsModel
import com.needcode.githubuserapp.domain.repository.ListRepository
import javax.inject.Inject

class ListUseCase @Inject constructor(private val repository: ListRepository) {
    suspend fun getPagedNews(page: Int, pageSize: Int): List<NewsModel>? {
        Log.e("USECASE", "GETTING DATA FROM REPO")
        return repository.getPagedNews(page, pageSize)
    }
}