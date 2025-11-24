package com.sopt.uniqlo.data.productlist.datasourceimpl

import com.sopt.uniqlo.data.productlist.datasource.ProductDataSource
import com.sopt.uniqlo.data.productlist.dto.ProductResponseDto
import com.sopt.uniqlo.data.productlist.service.ProductService
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor(
    private val productService: ProductService
) : ProductDataSource {
    override suspend fun getProducts(): List<ProductResponseDto> {
        return productService.getProducts().data ?: emptyList()
    }
}