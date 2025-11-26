package com.sopt.uniqlo.data.detailpage.datasource

import com.sopt.uniqlo.data.detailpage.dto.ProductDetailResponseDto
import com.sopt.uniqlo.data.detailpage.dto.StyleHintListResponseDto

interface DetailPageDataSource {
    suspend fun getProductDetail(
        productId: Int
    ): Result<ProductDetailResponseDto>

    suspend fun getStyleHintList(
        productId: Int
    ): Result<StyleHintListResponseDto>
}