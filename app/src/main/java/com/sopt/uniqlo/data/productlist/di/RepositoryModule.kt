package com.sopt.uniqlo.data.productlist.di

import com.sopt.uniqlo.data.productlist.respositoryimpl.ProductRepositoryImpl
import com.sopt.uniqlo.domain.productlist.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
}