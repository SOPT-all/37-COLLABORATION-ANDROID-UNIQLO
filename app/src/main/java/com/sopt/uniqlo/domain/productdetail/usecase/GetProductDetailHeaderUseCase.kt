package com.sopt.uniqlo.domain.productdetail.usecase

import com.sopt.uniqlo.domain.productdetail.entity.ProductDetailHeaderEntity
import com.sopt.uniqlo.domain.productlist.repository.ProductRepository
import javax.inject.Inject

class GetProductDetailHeaderUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(productId: Int): Result<ProductDetailHeaderEntity> {
        return productRepository.getProductDetail(productId)
    }
}