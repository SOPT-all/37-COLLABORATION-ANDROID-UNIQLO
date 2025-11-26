package com.sopt.uniqlo.presentation.detailpage.model

import com.sopt.uniqlo.domain.detailpage.entity.StyleHintEntity

data class StyleHintModel(
    val id: Int = 0,
    val imgUrl: String = "",
    val isLiked: Boolean = false,
)
fun StyleHintEntity.toUiModel(): List<StyleHintModel> {
    return styleHintImageUrlList.mapIndexed { index, url ->
        StyleHintModel(
            id = index + 1,
            imgUrl = url,
        )
    }
}