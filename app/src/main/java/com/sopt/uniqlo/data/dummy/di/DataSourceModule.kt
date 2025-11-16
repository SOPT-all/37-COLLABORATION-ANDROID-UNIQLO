package com.sopt.uniqlo.data.dummy.di

import com.sopt.uniqlo.data.dummy.datasource.GalleryDataSource
import com.sopt.uniqlo.data.dummy.datasourceimpl.GalleryDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindGalleryDataSource(
        galleryDataSourceImpl: GalleryDataSourceImpl
    ): GalleryDataSource
}