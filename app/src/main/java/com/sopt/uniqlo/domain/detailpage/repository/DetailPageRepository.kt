package com.sopt.uniqlo.domain.detailpage.repository

import com.sopt.uniqlo.domain.detailpage.entity.ProductDetailDescriptionEntity
import com.sopt.uniqlo.domain.detailpage.entity.StyleHintEntity

interface DetailPageRepository {
    suspend fun getProductDetailDescription(
        productId: Int
    ): Result<ProductDetailDescriptionEntity>

    suspend fun getStyleHintList(
        productId: Int
    ): Result<StyleHintEntity>
}