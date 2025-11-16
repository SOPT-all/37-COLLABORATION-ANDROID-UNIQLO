package com.sopt.uniqlo.data.dummy.datasourceimpl

import com.sopt.uniqlo.core.util.suspendRunCatching
import com.sopt.uniqlo.data.dummy.datasource.GalleryDataSource
import com.sopt.uniqlo.data.dummy.dto.GalleryImageResponseDto
import com.sopt.uniqlo.data.dummy.service.GalleryService
import javax.inject.Inject

class GalleryDataSourceImpl @Inject constructor(
    private val service: GalleryService
) : GalleryDataSource {
    override suspend fun getImages(page: Int, limit: Int): Result<List<GalleryImageResponseDto>> =
        suspendRunCatching {
            val response = service.getImages(page, limit)
            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                throw Exception("API 실패 ${response.code()}")
            }
        }
}