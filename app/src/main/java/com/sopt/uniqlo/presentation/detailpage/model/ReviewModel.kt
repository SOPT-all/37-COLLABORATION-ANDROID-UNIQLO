package com.sopt.uniqlo.presentation.detailpage.model

import com.sopt.uniqlo.domain.review.ReviewEntity

data class ReviewModel(
    val id: Int = 0,
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

fun ReviewEntity.toUiModel(id: Int) = ReviewModel(
    id = id,
    title = title,
    content = content,
    star = star,
    createdAt = createdAt,
    height = height,
    gender = gender,
    recommend = recommend,
    size = size,
    color = color,
    fit = fit
)