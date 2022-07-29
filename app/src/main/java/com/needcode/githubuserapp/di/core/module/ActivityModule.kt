package com.needcode.githubuserapp.di.core.module

import android.app.Application
import com.needcode.githubuserapp.CleanApplication
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivityModule {

    @ContributesAndroidInjector(modules = [ViewModelModule.MainActivity::class])
    fun mainActivityInjectior(): ViewModelModule.MainActivity


    @Binds
    fun bindApplication(app: CleanApplication): Application
}