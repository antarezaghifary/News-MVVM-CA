package com.needcode.githubuserapp.external

import androidx.recyclerview.widget.DiffUtil
import com.needcode.githubuserapp.data.model.NewsModel


/**
 * AdapterCallback berfungsi untuk melakukan differensiasi pada model yang lama dan yang baru,
 * digunakan untuk RecyclerView.ListAdapter ataupun RecyclerView.PagedListAdapter
 */
object AdapterCallback {
    fun mainRvCallback() = object : DiffUtil.ItemCallback<NewsModel>() {
        override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
            return oldItem.title == newItem.title
        }
    }
}