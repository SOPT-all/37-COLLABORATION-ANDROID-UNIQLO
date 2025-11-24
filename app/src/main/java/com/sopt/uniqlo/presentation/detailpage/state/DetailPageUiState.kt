package com.sopt.uniqlo.presentation.detailpage.state

import com.sopt.uniqlo.presentation.detailpage.TabState
import com.sopt.uniqlo.presentation.detailpage.model.DetailDescriptionModel
import com.sopt.uniqlo.presentation.detailpage.model.ReviewModel
import com.sopt.uniqlo.presentation.detailpage.model.SizeInformationItemModel
import com.sopt.uniqlo.presentation.detailpage.model.StyleHintModel

data class DetailPageUiState (
    val tabState: TabState = TabState.DETAIL,
    val detailDescription: DetailDescriptionModel = DetailDescriptionModel(
        detailPageUrl = "",
        detailText = "",
        descriptionText = emptyList(),
        featureDetailText = emptyList(),
        sizeDetailText = emptyList()
    ),
    val sizeInformationList: List<SizeInformationItemModel> = emptyList(),
    val styleHintList: List<StyleHintModel> = emptyList(),
    val reviewList: List<ReviewModel> = emptyList(),
    val reviewStarPointAverage: Float = 4.8f,
    val reviewFitAverage: Int = 5,
    val isWished: Boolean = false,
    val isLoading: Boolean = false,
)