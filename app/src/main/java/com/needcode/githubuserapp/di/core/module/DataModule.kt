package com.needcode.githubuserapp.di.core.module

import com.needcode.githubuserapp.data.datasource.list.ListDataSource
import com.needcode.githubuserapp.data.datasource.list.ListLocalDataSource
import com.needcode.githubuserapp.data.datasource.list.ListRemoteDataSource
import com.needcode.githubuserapp.data.repository.ListRepositoryImpl
import com.needcode.githubuserapp.data.source.local.dao.ListDao
import com.needcode.githubuserapp.data.source.network.ApiServiceImpl
import com.needcode.githubuserapp.domain.repository.ListRepository
import com.needcode.githubuserapp.domain.usecase.ListUseCase
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