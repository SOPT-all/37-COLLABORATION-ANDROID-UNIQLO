package com.sopt.uniqlo.domain.productlist.usecase

import com.sopt.uniqlo.data.productlist.FakeProductRepository
import com.sopt.uniqlo.domain.productlist.entity.ProductEntity
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val repository: FakeProductRepository
) {
    suspend operator fun invoke(category: String): Result<List<ProductEntity>> {
        return repository.getProducts(category)
    }
}