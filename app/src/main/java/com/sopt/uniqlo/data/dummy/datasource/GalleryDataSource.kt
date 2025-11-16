package com.sopt.uniqlo.data.dummy.datasource

import com.sopt.uniqlo.data.dummy.dto.GalleryImageResponseDto

interface GalleryDataSource {
    suspend fun getImages(
        page: Int,
        limit: Int
    ): Result<List<GalleryImageResponseDto>>
}