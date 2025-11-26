package com.sopt.uniqlo.domain.productlist.repository

import com.sopt.uniqlo.domain.productdetail.entity.ProductDetailEntity
import com.sopt.uniqlo.domain.productlist.entity.ProductEntity

interface ProductRepository {
    suspend fun getProducts(): Result<List<ProductEntity>>

    suspend fun getProductDetail(productId: Int): Result<ProductDetailEntity>
}