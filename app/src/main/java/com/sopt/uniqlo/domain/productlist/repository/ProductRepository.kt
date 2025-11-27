package com.sopt.uniqlo.domain.productlist.repository

import com.sopt.uniqlo.domain.productdetail.entity.ProductDetailHeaderEntity
import com.sopt.uniqlo.domain.productlist.entity.ProductEntity

interface ProductRepository {
    suspend fun getProducts(): Result<List<ProductEntity>>

    suspend fun getProductDetail(productId: Int): Result<ProductDetailHeaderEntity>
}