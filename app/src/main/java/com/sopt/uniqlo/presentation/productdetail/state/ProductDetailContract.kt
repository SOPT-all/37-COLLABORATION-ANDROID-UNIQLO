package com.sopt.uniqlo.presentation.productdetail.state

import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.presentation.productdetail.model.ProductInfoUiModel

data class ProductDetailState(
    val productDetailUiState: UiState<ProductInfoUiModel> = UiState.Loading,
    val selectedColorName: String = ""
)