package com.sopt.uniqlo.presentation.detailpage.model

data class ReviewModel(
    val title: String,
    val content: String,
    val star: Float,
    val createdAt: String,
    val height: String,
    val gender: String,
    val recommend: Int,
    val size: String,
    val color: String,
    val fit: String,
    val isHelpful: Boolean = false,
)
