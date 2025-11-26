package com.sopt.uniqlo.presentation.productlist.model

import androidx.compose.runtime.Immutable
import com.sopt.uniqlo.domain.productlist.entity.ProductEntity
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

@Immutable
data class ProductUiModel(
    val id: Int,
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

fun ProductEntity.toUiModel(isFavorite: Boolean) : ProductUiModel {
    return ProductUiModel(
        id = this.id,
        imageUrl = this.imageUrl,
        colorHexCodes = this.colorHexCodes,
        genderAndSizeRange = this.genderAndSizeRange,
        name = this.name,
        originalPrice = this.originalPrice,
        salePrice = this.salePrice,
        productTag = this.productTag,
        starAverage = this.starAverage,
        reviewCount = this.reviewCount,
        isFavorite = isFavorite
    )
}

fun List<ProductEntity>.toUiModel(favoriteMap : Map<Int, Boolean>) : PersistentList<ProductUiModel> {
    return map { entity ->
        entity.toUiModel(isFavorite = favoriteMap [entity.id] ?: false)
    }.toPersistentList()
 }