package com.sopt.uniqlo.domain.productlist.repository

import com.sopt.uniqlo.domain.productlist.entity.ProductEntity

interface ProductRepository {
    suspend fun getProducts(category: String): Result<List<ProductEntity>>
}