package com.sopt.uniqlo.presentation.productlist.state

import androidx.compose.runtime.Immutable
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.presentation.productlist.model.ProductUiModel
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class ProductListState(
    val productListState: UiState<ImmutableList<ProductUiModel>> = UiState.Loading,
    val selectedTabIndex: Int = 2,
    val totalCount: Int = 0
)

sealed interface ProductListSideEffect {
    data class ShowToast(val message: String) : ProductListSideEffect
}