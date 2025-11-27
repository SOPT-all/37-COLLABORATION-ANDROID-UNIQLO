package com.sopt.uniqlo.data.productlist.respositoryimpl

import com.sopt.uniqlo.data.productlist.datasource.ProductDataSource
import com.sopt.uniqlo.domain.productdetail.entity.ProductDetailHeaderEntity
import com.sopt.uniqlo.domain.productlist.entity.ProductEntity
import com.sopt.uniqlo.domain.productlist.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource,
) : ProductRepository {
    override suspend fun getProducts(): Result<List<ProductEntity>> {
        return productDataSource.getProducts().map { list ->
            list.map { dto -> dto.toEntity() }
        }
    }

    override suspend fun getProductDetail(productId: Int): Result<ProductDetailHeaderEntity> {
        return productDataSource.getProductDetail(productId).map { dto ->
            dto.toEntity()
        }
    }
}