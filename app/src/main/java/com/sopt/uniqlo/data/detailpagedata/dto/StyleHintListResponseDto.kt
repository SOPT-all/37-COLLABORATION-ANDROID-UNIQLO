package com.sopt.uniqlo.data.detailpage.dto

import com.sopt.uniqlo.domain.detailpage.entity.StyleHintEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StyleHintListResponseDto(
    @SerialName("styleHintImageUrlList")
    val styleHintImageUrlList: List<String>,
) {
    fun toDomain() = StyleHintEntity(
        styleHintImageUrlList = styleHintImageUrlList
    )
}