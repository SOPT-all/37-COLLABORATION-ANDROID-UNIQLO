package com.sopt.uniqlo.presentation.productlist.model

import androidx.compose.runtime.Immutable

@Immutable
data class ProductUiModel(
    val id: Long,
    val imageUrl: String,
    val colorHexCodes: List<String>,
    val genderAndSizeRange: String,
    val name: String,
    val originalPrice: String,
    val salePrice: String?,
    val productTag: String?,
    val starAverage: Float,
    val reviewCount: Int,
    val isFavorite: Boolean = false
)