package com.needcode.news_mvvm_ca

import android.app.Application
import com.needcode.news_mvvm_ca.di.core.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class CleanApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder()
            .application(this)
            .build().apply {
                inject(this@CleanApplication)
            }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return activityInjector
    }
}