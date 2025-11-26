package com.sopt.uniqlo.data.review

import com.sopt.uniqlo.core.util.suspendRunCatching
import javax.inject.Inject

class ReviewDataSourceImpl @Inject constructor(
    private val reviewService: ReviewService
) : ReviewDataSource {
    override suspend fun getReviews(productId: Long): Result<ReviewResponseDto> = suspendRunCatching {
        reviewService.getReviews(productId).data!!
    }
}