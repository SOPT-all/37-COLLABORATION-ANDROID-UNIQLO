package com.sopt.uniqlo.presentation.detailpage.model

import com.sopt.uniqlo.domain.detailpage.entity.ProductDetailEntity

data class DetailDescriptionModel(
    val detailPageUrl: List<String>,
    val detailText: String,
    val descriptionText: List<String>,
    val featureDetailText: List<String>,
    val sizeDetailText: List<String>,
)

fun ProductDetailEntity.toUiModel() : DetailDescriptionModel {
    return DetailDescriptionModel(
        detailPageUrl = detailImageUrl,
        detailText = detailText,
        descriptionText = descriptionText,
        featureDetailText = featureDetailText,
        sizeDetailText = sizeDetailText
    )
}