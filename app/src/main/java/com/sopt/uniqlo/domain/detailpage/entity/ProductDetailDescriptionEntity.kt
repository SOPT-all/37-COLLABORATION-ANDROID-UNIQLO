package com.sopt.uniqlo.domain.detailpage.entity

data class ProductDetailDescriptionEntity (
    val detailImageUrl: List<String>,
    val detailText: String,
    val descriptionText: List<String>,
    val featureDetailText: List<String>,
    val sizeDetailText: List<String>
)