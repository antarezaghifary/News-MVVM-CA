package com.needcode.news_mvvm_ca.presenter.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * sebagai Class Dasar Dari Semua Activity
 */


abstract class BaseActivity<VM : ViewModel, BINDING : ViewDataBinding> : DaggerAppCompatActivity() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: BINDING

    @Inject
    lateinit var daggerViewModelfactory: DaggerViewModelFactory

    protected abstract fun createViewModel(): VM
    protected abstract fun createBinding(): BINDING
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
        binding = createBinding()
    }

}