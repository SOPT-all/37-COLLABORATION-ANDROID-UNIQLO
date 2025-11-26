package com.sopt.uniqlo.data.detailpage.di

import com.sopt.uniqlo.data.detailpage.repositoryimpl.DetailPageRepositoryImpl
import com.sopt.uniqlo.domain.detailpage.repository.DetailPageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindDetailPageRepository(
        detailPageRepositoryModule: DetailPageRepositoryImpl
    ): DetailPageRepository
}