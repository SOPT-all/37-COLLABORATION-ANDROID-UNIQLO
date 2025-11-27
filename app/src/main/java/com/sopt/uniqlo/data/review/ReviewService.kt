package com.sopt.uniqlo.data.review

import com.sopt.uniqlo.core.network.model.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewService {
    @GET("products/{productId}/reviews")
    suspend fun getReviews(
        @Path("productId") productId: Long
    ): BaseResponse<ReviewResponseDto>
}