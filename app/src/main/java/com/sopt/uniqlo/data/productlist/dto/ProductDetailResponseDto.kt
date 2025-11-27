package com.sopt.uniqlo.data.productlist.dto

import com.sopt.uniqlo.domain.productdetail.entity.ProductDetailHeaderEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailResponseDto(
    @SerialName("productId")
    val productId: Int,
    @SerialName("productImageUrl")
    val productImageUrl: List<String>,
    @SerialName("colorCode")
    val colorCode: List<String>,
    @SerialName("color")
    val colorMap: Map<String, String>,
    @SerialName("name")
    val name: String,
    @SerialName("originPrice")
    val originPrice: String,
    @SerialName("salePrice")
    val salePrice: String? = null,
    @SerialName("starAverage")
    val starAverage: Float,
    @SerialName("reviewCount")
    val reviewCount: Int
) {
    fun toEntity() = ProductDetailHeaderEntity(
        id = productId,
        imageUrl = productImageUrl,
        colorHexCodes = colorCode,
        colorMap = colorMap,
        name = name,
        originPrice = originPrice.removeSuffix("원"),
        salePrice = salePrice?.removeSuffix("원"),
        starAverage = starAverage,
        reviewCount = reviewCount
    )
}