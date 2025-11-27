package com.sopt.uniqlo.domain.review

import javax.inject.Inject

class GetReviewListUseCase @Inject constructor(
    private val reviewRepository: ReviewRepository
) {
    suspend operator fun invoke(productId: Long): Result<List<ReviewEntity>> =
        reviewRepository.getReviews(productId)
}