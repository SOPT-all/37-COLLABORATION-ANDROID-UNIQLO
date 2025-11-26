package com.sopt.uniqlo.presentation.detailpage.model

import androidx.compose.ui.graphics.Color
import com.sopt.uniqlo.core.extension.toComposeColor
import com.sopt.uniqlo.domain.productdetail.entity.ProductDetailHeaderEntity
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

data class ColorOption(
    val name: String,
    val color: Color
)

data class ProductInfoUiModel(
    val name: String = "",
    val imageUrls: ImmutableList<String> = persistentListOf(),
    val productNumber: String = "",
    val colorName: String = "",
    val colorOptions: ImmutableList<ColorOption> = persistentListOf(),
    val price: String = "",
    val rating: Float = 0f,
    val reviewCount: Int = 0
)

fun ProductDetailHeaderEntity.toUiModel() : ProductInfoUiModel {
    val options = this.colorHexCodes.mapNotNull { hexCode ->
        val colorName = this.colorMap[hexCode]
        if (colorName != null) {
            ColorOption(
                name = colorName,
                color = hexCode.toComposeColor()
            )
        } else null
    }.toImmutableList()

    val defaultHexCode = this.colorHexCodes.firstOrNull() ?: ""
    val defaultColorName = this.colorMap[defaultHexCode] ?: ""

    return ProductInfoUiModel(
        name = this.name,
        imageUrls = this.imageUrl.toImmutableList(),
        productNumber = this.id.toString(),
        colorName = defaultColorName,
        colorOptions = options,
        price = this.originPrice,
        rating = this.starAverage,
        reviewCount = this.reviewCount
    )
}