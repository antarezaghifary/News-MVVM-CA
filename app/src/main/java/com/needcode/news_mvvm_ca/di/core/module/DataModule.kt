package com.needcode.news_mvvm_ca.di.core.module

import com.needcode.news_mvvm_ca.data.datasource.list.ListDataSource
import com.needcode.news_mvvm_ca.data.datasource.list.ListLocalDataSource
import com.needcode.news_mvvm_ca.data.datasource.list.ListRemoteDataSource
import com.needcode.news_mvvm_ca.data.repository.ListRepositoryImpl
import com.needcode.news_mvvm_ca.data.source.local.dao.ListDao
import com.needcode.news_mvvm_ca.data.source.network.ApiServiceImpl
import com.needcode.news_mvvm_ca.domain.repository.ListRepository
import com.needcode.news_mvvm_ca.domain.usecase.ListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * berisi Provides apa saja yang diperlukan pada layer data
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideApiServiceImpl(): ApiServiceImpl {
        return ApiServiceImpl()
    }

    @Provides
    @Singleton
    fun provideListRepository(
        remote: ListDataSource.Remote,
        local: ListDataSource.Local
    ): ListRepository {
        return ListRepositoryImpl(local, remote)
    }

    @Provides
    @Singleton
    fun provideListLocalDataSource(dao: ListDao): ListDataSource.Local {
        return ListLocalDataSource(dao)
    }

    @Provides
    @Singleton
    fun provideListRemoteDataSource(api: ApiServiceImpl): ListDataSource.Remote {
        return ListRemoteDataSource(api)
    }

    @Provides
    fun provideGetListUseCase(repository: ListRepository): ListUseCase {
        return ListUseCase(repository)
    }
}