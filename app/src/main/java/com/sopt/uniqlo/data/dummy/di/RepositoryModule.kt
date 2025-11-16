package com.sopt.uniqlo.data.dummy.di

import com.sopt.uniqlo.data.dummy.respositoryimpl.GalleryRepositoryImpl
import com.sopt.uniqlo.domain.dummy.repository.GalleryRepository
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
    abstract fun bindGalleryRepository(
        galleryRepositoryImpl: GalleryRepositoryImpl
    ): GalleryRepository
}