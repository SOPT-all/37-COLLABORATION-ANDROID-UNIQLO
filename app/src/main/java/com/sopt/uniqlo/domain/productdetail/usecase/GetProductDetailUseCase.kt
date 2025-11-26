package com.sopt.uniqlo.domain.productdetail.usecase

import com.sopt.uniqlo.domain.productdetail.entity.ProductDetailEntity
import com.sopt.uniqlo.domain.productlist.repository.ProductRepository
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(productId: Int): Result<ProductDetailEntity> {
        return productRepository.getProductDetail(productId)
    }
}