package com.sopt.uniqlo.domain.review

interface ReviewRepository {
    suspend fun getReviews(productId: Long): Result<List<ReviewEntity>>
}