package com.sopt.uniqlo.data.detailpage.di

import com.sopt.uniqlo.data.detailpage.service.DetailPageService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun provideDetailPageService(retrofit: Retrofit): DetailPageService =
        retrofit.create()
}