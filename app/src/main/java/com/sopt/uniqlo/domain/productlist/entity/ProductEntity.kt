package com.sopt.uniqlo.domain.productlist.entity

data class ProductEntity(
    val id: Int,
    val imageUrl: String,
    val colorHexCodes: List<String>,
    val genderAndSizeRange: String,
    val name: String,
    val originalPrice: String,
    val salePrice: String?,
    val productTag: String?,
    val starAverage: Float,
    val reviewCount: Int
)