package com.needcode.news_mvvm_ca.presenter.list.adapter

import com.needcode.news_mvvm_ca.data.model.NewsModel


/**
 * Action Listener untuk handle event dari layout.
 */
interface MainRvAction {
    fun onItemClick(data: NewsModel)
}