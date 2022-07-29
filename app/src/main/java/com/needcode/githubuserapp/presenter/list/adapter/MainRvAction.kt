package com.needcode.githubuserapp.presenter.list.adapter

import com.needcode.githubuserapp.data.model.NewsModel


/**
 * Action Listener untuk handle event dari layout.
 */
interface MainRvAction {
    fun onItemClick(data: NewsModel)
}