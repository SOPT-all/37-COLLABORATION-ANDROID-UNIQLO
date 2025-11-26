package com.sopt.uniqlo.data.productlist.dto

import com.sopt.uniqlo.domain.productlist.entity.ProductEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponseDto(
    @SerialName("productId")
    val productId: Int,
    @SerialName("productImageUrl")
    val productImageUrl: String,
    @SerialName("colorCode")
    val colorCode: List<String>,
    @SerialName("genderAndSizeRange")
    val genderAndSizeRange: String,
    @SerialName("name")
    val name: String,
    @SerialName("originPrice")
    val originPrice: String,
    @SerialName("salePrice")
    val salePrice: String? = null,
    @SerialName("productType")
    val productType: String? = null,
    @SerialName("starAverage")
    val starAverage: Float,
    @SerialName("reviewCount")
    val reviewCount: Int
) {
    fun toEntity() = ProductEntity(
        id = productId,
        imageUrl = productImageUrl,
        colorHexCodes = colorCode,
        genderAndSizeRange = genderAndSizeRange,
        name = name,
        originalPrice = originPrice.removeSuffix("원"),
        salePrice = salePrice?.removeSuffix("원"),
        productTag = productType,
        starAverage = starAverage,
        reviewCount = reviewCount
    )
}