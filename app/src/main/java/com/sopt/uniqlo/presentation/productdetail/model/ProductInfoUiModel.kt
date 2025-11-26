package com.sopt.uniqlo.presentation.productdetail.model

import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.ImmutableList

data class ColorOption(
    val name: String,
    val color: Color
)

data class ProductInfoUiModel(
    val name: String,
    val imageUrls: ImmutableList<String>,
    val productNumber: String,
    val colorName: String,
    val colorOptions: ImmutableList<ColorOption>,
    val price: String,
    val rating: Float,
    val reviewCount: Int
)