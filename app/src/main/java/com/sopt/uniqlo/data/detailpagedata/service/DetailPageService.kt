package com.sopt.uniqlo.data.detailpage.service

import com.sopt.uniqlo.core.network.model.BaseResponse
import com.sopt.uniqlo.data.detailpage.dto.ProductDetailDescriptionResponseDto
import com.sopt.uniqlo.data.detailpage.dto.StyleHintListResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailPageService {

    @GET("products/{productId}/details")
    suspend fun getProductDetail(
        @Path("productId") productId: Int
    ): Response<BaseResponse<ProductDetailDescriptionResponseDto>>

    @GET("products/{productId}/hints")
    suspend fun getStyleHintList(
        @Path("productId") productId: Int
    ): Response<BaseResponse<StyleHintListResponseDto>>
}