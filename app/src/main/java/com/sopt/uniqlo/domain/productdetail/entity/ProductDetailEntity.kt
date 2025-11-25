package com.sopt.uniqlo.domain.productdetail.entity

data class ProductDetailEntity(
    val id: Long,
    val imageUrl: List<String>,
    val colorHexCodes: List<String>,
    val colorMap: Map<String, String>,
    val name: String,
    val originPrice: String,
    val salePrice: String?,
    val starAverage: Float,
    val reviewCount: Int
)