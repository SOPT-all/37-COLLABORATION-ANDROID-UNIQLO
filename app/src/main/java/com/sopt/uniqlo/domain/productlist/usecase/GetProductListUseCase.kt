package com.sopt.uniqlo.domain.productlist.usecase

import com.sopt.uniqlo.domain.productlist.entity.ProductEntity
import com.sopt.uniqlo.domain.productlist.repository.ProductRepository
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): Result<List<ProductEntity>> {
        return productRepository.getProducts()
    }
}