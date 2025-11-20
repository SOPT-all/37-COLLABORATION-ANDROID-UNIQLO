package com.sopt.uniqlo.presentation.productlist.model

import androidx.compose.runtime.Immutable
import com.sopt.uniqlo.domain.productlist.entity.ProductEntity
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

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

fun List<ProductEntity>.toUiModel(favoriteMap : Map<Long, Boolean>) : PersistentList<ProductUiModel> {
    return map { entity ->
        ProductUiModel(
            id = entity.id,
            imageUrl = entity.imageUrl,
            colorHexCodes = entity.colorHexCodes,
            genderAndSizeRange = entity.genderAndSizeRange,
            name = entity.name,
            originalPrice = entity.originalPrice,
            salePrice = entity.salePrice,
            productTag = entity.productTag,
            starAverage = entity.starAverage,
            reviewCount = entity.reviewCount,
            isFavorite = favoriteMap [entity.id] ?: false
        )
    }.toPersistentList()
 }