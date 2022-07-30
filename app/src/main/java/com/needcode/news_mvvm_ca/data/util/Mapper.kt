package com.needcode.news_mvvm_ca.data.util

import com.needcode.news_mvvm_ca.data.model.NewsModel
import com.needcode.news_mvvm_ca.data.source.local.entity.LocalNewsModel

object Mapper {
    fun toRemoteList(list: List<LocalNewsModel>): List<NewsModel> {
        return list.map { return@map NewsModel(it.title, it.image) }
    }

    fun toLocalList(list: List<NewsModel>?): List<LocalNewsModel> {
        if (list != null) {
            return list.map { return@map LocalNewsModel(null, it.title, it.image) }
        } else return emptyList()
    }
}