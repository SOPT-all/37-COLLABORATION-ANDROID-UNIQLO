package com.sopt.uniqlo.domain.detailpage.usecase

import com.sopt.uniqlo.domain.detailpage.repository.DetailPageRepository
import jakarta.inject.Inject

class GetProductDetailUseCase @Inject constructor(
    private val repository: DetailPageRepository
){
    suspend operator fun invoke(productId: Int) = repository.getProductDetailDescription(productId)
}