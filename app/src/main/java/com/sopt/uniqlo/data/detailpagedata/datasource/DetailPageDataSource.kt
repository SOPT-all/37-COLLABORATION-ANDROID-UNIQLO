package com.sopt.uniqlo.data.detailpage.datasource

import com.sopt.uniqlo.data.detailpage.dto.ProductDetailDescriptionResponseDto
import com.sopt.uniqlo.data.detailpage.dto.StyleHintListResponseDto

interface DetailPageDataSource {
    suspend fun getProductDetailDescription(
        productId: Int
    ): Result<ProductDetailDescriptionResponseDto>

    suspend fun getStyleHintList(
        productId: Int
    ): Result<StyleHintListResponseDto>
}