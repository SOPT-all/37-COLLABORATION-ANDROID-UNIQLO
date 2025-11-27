package com.sopt.uniqlo.data.review

import com.sopt.uniqlo.domain.review.ReviewEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponseDto(
    @SerialName("reviews")
    val reviews: List<ReviewResponseData>
) {
    fun toDomain() = reviews.map { it.toDomain() }
}

@Serializable
data class ReviewResponseData(
    @SerialName("title")
    val title: String,
    @SerialName("content")
    val content: String,
    @SerialName("star")
    val star: Float,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("height")
    val height: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("recommend")
    val recommend: Int,
    @SerialName("size")
    val size: String,
    @SerialName("color")
    val color: String,
    @SerialName("fit")
    val fit: String
) {
    fun toDomain() = ReviewEntity(
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
}
