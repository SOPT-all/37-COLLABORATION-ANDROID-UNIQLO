package com.sopt.uniqlo.data.detailpage.datasourceimpl

import com.sopt.uniqlo.core.util.suspendRunCatching
import com.sopt.uniqlo.data.detailpage.datasource.DetailPageDataSource
import com.sopt.uniqlo.data.detailpage.dto.ProductDetailDescriptionResponseDto
import com.sopt.uniqlo.data.detailpage.dto.StyleHintListResponseDto
import com.sopt.uniqlo.data.detailpage.service.DetailPageService
import javax.inject.Inject

class DetailPageDataSourceImpl @Inject constructor(
    private val service: DetailPageService
) : DetailPageDataSource {
    override suspend fun getProductDetailDescription(productId: Int): Result<ProductDetailDescriptionResponseDto> =
        suspendRunCatching {
            val response = service.getProductDetail(productId)
            if (response.isSuccessful) {
                val baseResponse =
                    response.body() ?: throw IllegalStateException("API 응답이 Null입니다.")
                baseResponse.data ?: throw IllegalStateException("API 응답 데이터가 Null입니다.")
            } else {
                throw Exception("API 실패 ${response.code()}")
            }
        }

    override suspend fun getStyleHintList(productId: Int): Result<StyleHintListResponseDto> =
        suspendRunCatching {
            val response = service.getStyleHintList(productId)
            if (response.isSuccessful) {
                val baseResponse =
                    response.body() ?: throw IllegalStateException("API 응답이 Null입니다.")
                baseResponse.data ?: throw IllegalStateException("API 응답 데이터가 Null입니다.")
            } else {
                throw Exception("API 실패 ${response.code()}")
            }
        }
}