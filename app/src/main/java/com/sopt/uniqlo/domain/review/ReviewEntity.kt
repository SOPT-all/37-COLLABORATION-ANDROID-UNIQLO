package com.sopt.uniqlo.domain.review

data class ReviewEntity(
    val title: String,
    val content: String,
    val star: Float,
    val createdAt: String,
    val height: String,
    val gender: String,
    val recommend: Int,
    val size: String,
    val color: String,
    val fit: String
)
