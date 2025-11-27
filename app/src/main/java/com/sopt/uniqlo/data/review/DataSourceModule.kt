package com.sopt.uniqlo.data.review

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindReviewDataSource(
        reviewDataSourceImpl: ReviewDataSourceImpl
    ): ReviewDataSource

}