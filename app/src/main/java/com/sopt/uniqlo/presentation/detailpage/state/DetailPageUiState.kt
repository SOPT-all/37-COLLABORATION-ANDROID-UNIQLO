package com.sopt.uniqlo.presentation.detailpage.state

import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.presentation.detailpage.TabState
import com.sopt.uniqlo.presentation.detailpage.model.DetailDescriptionModel
import com.sopt.uniqlo.presentation.detailpage.model.ProductInfoUiModel
import com.sopt.uniqlo.presentation.detailpage.model.ReviewModel
import com.sopt.uniqlo.presentation.detailpage.model.SizeInformationItemModel
import com.sopt.uniqlo.presentation.detailpage.model.StyleHintModel

data class DetailPageUiState (
    val productId: Int = 1,
    val tabState: TabState = TabState.TOP,
    val detailDescription: DetailDescriptionModel = DetailDescriptionModel(
        detailPageUrl = emptyList(),
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

    val productDetailUiState: UiState<ProductInfoUiModel> = UiState.Loading,
    val selectedColorName: String = ""
)

sealed interface ProductDetailSideEffect {
    data class ShowToast(val message: String) : ProductDetailSideEffect
}