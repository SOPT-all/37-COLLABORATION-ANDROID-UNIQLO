package com.sopt.uniqlo.data.detailpage.dto

import com.sopt.uniqlo.domain.detailpage.entity.ProductDetailEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailResponseDto(
    @SerialName("detailImageUrlList")
    val detailImageUrl: List<String>,
    @SerialName("detailText")
    val detailText: String,
    @SerialName("descriptionTextList")
    val descriptionText: List<String>,
    @SerialName("featureDetailTextList")
    val featureDetailText: List<String>,
    @SerialName("sizeDetailTextList")
    val sizeDetailText: List<String>
) {
    fun toDomain() = ProductDetailEntity(
        detailImageUrl = detailImageUrl,
        detailText = detailText,
        descriptionText = descriptionText,
        featureDetailText = featureDetailText,
        sizeDetailText = sizeDetailText
    )
}