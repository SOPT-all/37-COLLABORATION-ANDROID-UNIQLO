package com.sopt.uniqlo.data.productlist.datasource

import com.sopt.uniqlo.data.productlist.dto.ProductDetailResponseDto
import com.sopt.uniqlo.data.productlist.dto.ProductResponseDto

interface ProductDataSource {
    suspend fun getProducts(): List<ProductResponseDto>

    suspend fun getProductDetail(productId: Long): ProductDetailResponseDto
}