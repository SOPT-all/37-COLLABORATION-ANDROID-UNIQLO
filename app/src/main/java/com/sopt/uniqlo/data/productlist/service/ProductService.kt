package com.sopt.uniqlo.data.productlist.service

import com.sopt.uniqlo.core.network.model.BaseResponse
import com.sopt.uniqlo.data.productlist.dto.ProductDetailResponseDto
import com.sopt.uniqlo.data.productlist.dto.ProductResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("products")
    suspend fun getProducts(): BaseResponse<List<ProductResponseDto>>

    @GET("products/{productId}")
    suspend fun getProductDetail(
        @Path("productId") productId: Int
    ): BaseResponse<ProductDetailResponseDto>
}