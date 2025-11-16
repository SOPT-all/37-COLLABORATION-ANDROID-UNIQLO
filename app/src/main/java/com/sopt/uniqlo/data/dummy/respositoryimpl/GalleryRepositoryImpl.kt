package com.sopt.uniqlo.data.dummy.respositoryimpl

import com.sopt.uniqlo.core.util.suspendRunCatching
import com.sopt.uniqlo.data.dummy.datasource.GalleryDataSource
import com.sopt.uniqlo.domain.dummy.entity.GalleryImageEntity
import com.sopt.uniqlo.domain.dummy.repository.GalleryRepository
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val dataSource: GalleryDataSource
) : GalleryRepository {
    override suspend fun getGalleryImageList(
        page: Int,
        limit: Int
    ): Result<List<GalleryImageEntity>> = suspendRunCatching {
        val dtoList = dataSource.getImages(page, limit).getOrDefault(emptyList())
        dtoList.map { it.toDomain() }
    }
}