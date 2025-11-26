package com.sopt.uniqlo.data.review


interface ReviewDataSource {
    suspend fun getReviews(productId: Long): Result<ReviewResponseDto>
}