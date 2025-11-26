package com.sopt.uniqlo.presentation.category.model

import androidx.annotation.DrawableRes

data class ContentUiModel(
    val id:Int,
    @param:DrawableRes val image: Int,
    val title: String
)
