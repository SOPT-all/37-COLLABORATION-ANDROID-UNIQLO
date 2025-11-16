package com.sopt.uniqlo.data.dummy.di

import com.sopt.uniqlo.data.dummy.service.GalleryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideGalleryService(retrofit: Retrofit): GalleryService =
        retrofit.create()
}