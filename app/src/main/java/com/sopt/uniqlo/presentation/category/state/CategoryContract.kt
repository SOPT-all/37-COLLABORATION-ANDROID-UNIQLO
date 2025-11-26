package com.sopt.uniqlo.presentation.category.state

import com.sopt.uniqlo.R
import com.sopt.uniqlo.presentation.category.model.ContentUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class CategoryUiState(
    val tabList: ImmutableList<String> = persistentListOf("WOMEN", "MEN", "KIDS", "BABY"),

    val categoryList: ImmutableList<String> = persistentListOf(),

    val categoryContentList: ImmutableList<ContentUiModel> = persistentListOf()
) {
    companion object {
        val contentData = listOf(
            ContentUiModel(1, R.drawable.img_category_5, "경량 패딩\n(PUFFTECH)"),
            ContentUiModel(2, R.drawable.img_category_1, "파카 & 블루종 \n& 후리스"),
            ContentUiModel(3, R.drawable.img_category_2, "재킷 & 블레이저"),
            ContentUiModel(4, R.drawable.img_category_4, "코트"),
            ContentUiModel(5, R.drawable.img_category_3, "다운 & 패딩"),
        )
    }
}

sealed interface CategorySideEffect {
    data class ShowToast(val message: String) : CategorySideEffect
}