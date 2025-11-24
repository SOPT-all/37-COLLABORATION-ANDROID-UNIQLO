package com.sopt.uniqlo.data.productlist.service

import com.sopt.uniqlo.core.network.model.BaseResponse
import com.sopt.uniqlo.data.productlist.dto.ProductResponseDto
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProducts(): BaseResponse<List<ProductResponseDto>>
}