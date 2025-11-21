package com.sopt.uniqlo.presentation.productlist.model

import androidx.compose.runtime.Immutable

@Immutable
data class FilterChipModel(
    val id: Long,
    val name: String,
    val icon: Int,
    val isSelected: Boolean
)