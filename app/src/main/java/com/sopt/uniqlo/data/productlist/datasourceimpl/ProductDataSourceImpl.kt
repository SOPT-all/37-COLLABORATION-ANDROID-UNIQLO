package com.sopt.uniqlo.data.productlist.datasourceimpl

import com.sopt.uniqlo.data.productlist.datasource.ProductDataSource
import com.sopt.uniqlo.data.productlist.dto.ProductDetailResponseDto
import com.sopt.uniqlo.data.productlist.dto.ProductResponseDto
import com.sopt.uniqlo.data.productlist.service.ProductService
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor(
    private val productService: ProductService
) : ProductDataSource {
    override suspend fun getProducts(): Result<List<ProductResponseDto>> {
        return try {
            val response = productService.getProducts()
            if (response.data != null) {
                Result.success(response.data)
            } else {
                Result.failure(Exception("서버에서 데이터를 받지 못했습니다."))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getProductDetail(productId: Int): Result<ProductDetailResponseDto> {
        return try {
            val response = productService.getProductDetail(productId)
            if (response.data != null) {
                Result.success(response.data)
            } else {
                Result.failure(Exception("상품 상세 정보를 받지 못했습니다. productId: $productId"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}