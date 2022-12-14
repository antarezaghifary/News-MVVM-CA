package com.needcode.news_mvvm_ca.di.core.component

import com.needcode.news_mvvm_ca.CleanApplication
import com.needcode.news_mvvm_ca.di.core.module.ActivityModule
import com.needcode.news_mvvm_ca.di.core.module.AppModule
import com.needcode.news_mvvm_ca.di.core.module.DataModule
import com.needcode.news_mvvm_ca.di.core.module.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        DatabaseModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: CleanApplication): Builder
        fun build(): ApplicationComponent
    }

    override fun inject(instance: DaggerApplication?)

    fun inject(application: CleanApplication)
}