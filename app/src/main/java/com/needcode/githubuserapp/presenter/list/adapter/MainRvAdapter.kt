package com.needcode.githubuserapp.presenter.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.needcode.githubuserapp.R
import com.needcode.githubuserapp.data.model.NewsModel
import com.needcode.githubuserapp.databinding.MainItemBinding
import com.needcode.githubuserapp.external.AdapterCallback
import com.needcode.githubuserapp.external.LoadingState

class MainRvAdapter :
    PagedListAdapter<NewsModel, RecyclerView.ViewHolder>(AdapterCallback.mainRvCallback()) {

    companion object {
        const val VIEW_TYPE_ITEM = 1
        const val VIEW_TYPE_LOAD = 2
    }

    private var loadingState = LoadingState.LOADING

    private var action: MainRvAction? = null
    fun setActionListener(listener: MainRvAction) {
        this.action = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_ITEM) {
            val binding: MainItemBinding =
                DataBindingUtil.inflate(inflater, R.layout.main_item, parent, false)
            Holder(binding)
        } else {
            val x = inflater.inflate(R.layout.item_load_more, parent, false)
            LoadMoreHolder(x)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is Holder) {
            try {
                val item = getItem(position)
                item?.let {
                    holder.bindView(it, action)
                }
            } catch (e: IndexOutOfBoundsException) {
                e.printStackTrace()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) VIEW_TYPE_ITEM else VIEW_TYPE_LOAD
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1 else 0
    }

    private fun hasFooter(): Boolean {
        return super.getItemCount() != 0 && loadingState == LoadingState.LOADING
    }

    class Holder(private val binding: MainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(data: NewsModel, action: MainRvAction?) {
            binding.data = data
            binding.action = action
            binding.executePendingBindings()
        }
    }

    internal class LoadMoreHolder(x: View) : RecyclerView.ViewHolder(x)
}