package com.needcode.githubuserapp.di.core.module

import androidx.lifecycle.ViewModel
import com.needcode.githubuserapp.di.key.ViewModelKey
import com.needcode.githubuserapp.presenter.list.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * untuk Untuk mengatur agar MainActivityViewModel bisa diakses di DaggerViewModelFactory
 */
@Module
abstract class ViewModelModule {

    @Module
    abstract inner class MainActivity {
        @Binds
        @IntoMap
        @ViewModelKey(MainActivityViewModel::class)
        abstract fun bindMainActivityViewModel(vm: MainActivityViewModel): ViewModel
    }

}