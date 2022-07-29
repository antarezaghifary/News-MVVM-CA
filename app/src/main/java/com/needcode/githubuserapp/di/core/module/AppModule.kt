package com.needcode.githubuserapp.di.core.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AppModule Berfungsi jika ingin menambahkan sesuatu di Application Seperti Konfigirasi
 * SharedPreference dan menambahkan ViewModelFactoryModule.
 */

@Module(includes = [DaggerViewModelFactoryModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

}