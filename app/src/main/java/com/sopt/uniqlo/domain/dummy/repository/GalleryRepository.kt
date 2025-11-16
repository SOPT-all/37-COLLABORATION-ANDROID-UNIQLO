package com.sopt.uniqlo.domain.dummy.repository

import com.sopt.uniqlo.domain.dummy.entity.GalleryImageEntity

interface GalleryRepository {
    suspend fun getGalleryImageList(
        page: Int,
        limit: Int
    ) : Result<List<GalleryImageEntity>>
}