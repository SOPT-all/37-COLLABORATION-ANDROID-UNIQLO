package com.sopt.uniqlo.data.productlist.di

import com.sopt.uniqlo.data.productlist.datasource.ProductDataSource
import com.sopt.uniqlo.data.productlist.datasourceimpl.ProductDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindProductDataSource(
        productDataSourceImpl: ProductDataSourceImpl
    ): ProductDataSource
}