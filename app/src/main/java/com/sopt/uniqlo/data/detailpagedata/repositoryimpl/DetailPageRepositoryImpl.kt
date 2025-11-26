package com.sopt.uniqlo.data.detailpage.repositoryimpl

import com.sopt.uniqlo.core.util.suspendRunCatching
import com.sopt.uniqlo.data.detailpage.datasource.DetailPageDataSource
import com.sopt.uniqlo.data.detailpage.dto.ProductDetailResponseDto
import com.sopt.uniqlo.data.detailpage.dto.StyleHintListResponseDto
import com.sopt.uniqlo.domain.detailpage.entity.ProductDetailEntity
import com.sopt.uniqlo.domain.detailpage.entity.StyleHintEntity
import com.sopt.uniqlo.domain.detailpage.repository.DetailPageRepository
import jakarta.inject.Inject
import timber.log.Timber

class DetailPageRepositoryImpl @Inject constructor(
    private val dataSource: DetailPageDataSource
) : DetailPageRepository {

    override suspend fun getProductDetail(productId: Int): Result<ProductDetailEntity> =
        suspendRunCatching {
            val dto = dataSource.getProductDetail(productId).getOrElse { exception ->
                Timber.e("$exception")
                ProductDetailResponseDto(
                    detailImageUrl = emptyList(),
                    detailText = "",
                    descriptionText = emptyList(),
                    featureDetailText = emptyList(),
                    sizeDetailText = emptyList()
                )
            }
            dto.toDomain()
        }

    override suspend fun getStyleHintList(productId: Int): Result<StyleHintEntity> =
        suspendRunCatching {
            val dtoList = dataSource.getStyleHintList(productId).getOrElse { exception ->
                Timber.e( "$exception")
                StyleHintListResponseDto(emptyList())
            }
            dtoList.toDomain()
        }
}