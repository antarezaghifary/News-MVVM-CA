package com.needcode.githubuserapp.di.core.module

import androidx.lifecycle.ViewModelProvider
import com.needcode.githubuserapp.presenter.base.DaggerViewModelFactory
import dagger.Binds
import dagger.Module


/**
 * berfungsi agar DaggerViewModelFactory dapat diakses di dagger generated code.
 */
@Module
abstract class DaggerViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}