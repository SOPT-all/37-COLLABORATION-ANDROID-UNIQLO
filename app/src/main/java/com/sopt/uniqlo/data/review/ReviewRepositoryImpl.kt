package com.sopt.uniqlo.data.review

import com.sopt.uniqlo.core.util.suspendRunCatching
import com.sopt.uniqlo.domain.review.ReviewEntity
import com.sopt.uniqlo.domain.review.ReviewRepository
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    private val reviewDataSource: ReviewDataSource
) : ReviewRepository {
    override suspend fun getReviews(productId: Long): Result<List<ReviewEntity>> =
        suspendRunCatching {
            reviewDataSource.getReviews(productId = productId).getOrThrow().toDomain()
        }
}