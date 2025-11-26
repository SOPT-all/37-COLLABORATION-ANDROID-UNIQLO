package com.sopt.uniqlo.domain.detailpage.repository

import com.sopt.uniqlo.domain.detailpage.entity.ProductDetailEntity
import com.sopt.uniqlo.domain.detailpage.entity.StyleHintEntity

interface DetailPageRepository {
    suspend fun getProductDetail(
        productId: Int
    ): Result<ProductDetailEntity>

    suspend fun getStyleHintList(
        productId: Int
    ): Result<StyleHintEntity>
}