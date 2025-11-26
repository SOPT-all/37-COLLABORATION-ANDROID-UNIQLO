package com.sopt.uniqlo.data.detailpage.di

import com.sopt.uniqlo.data.detailpage.datasource.DetailPageDataSource
import com.sopt.uniqlo.data.detailpage.datasourceimpl.DetailPageDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindDetailPageDataSource(
        detailPageDataSourceImpl: DetailPageDataSourceImpl
    ): DetailPageDataSource
}