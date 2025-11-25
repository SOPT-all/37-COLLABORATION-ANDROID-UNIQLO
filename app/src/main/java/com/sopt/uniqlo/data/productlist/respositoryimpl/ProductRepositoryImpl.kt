package com.sopt.uniqlo.data.productlist.respositoryimpl

import com.sopt.uniqlo.core.util.suspendRunCatching
import com.sopt.uniqlo.data.productlist.datasource.ProductDataSource
import com.sopt.uniqlo.domain.productdetail.entity.ProductDetailEntity
import com.sopt.uniqlo.domain.productlist.entity.ProductEntity
import com.sopt.uniqlo.domain.productlist.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource,
) : ProductRepository {
    override suspend fun getProducts(): Result<List<ProductEntity>> = suspendRunCatching {
        productDataSource.getProducts().map { it.toProductEntity() }
    }

    override suspend fun getProductDetail(productId: Long): Result<ProductDetailEntity> =
        suspendRunCatching {
            productDataSource.getProductDetail(productId).toProductDetailEntity()
        }
}