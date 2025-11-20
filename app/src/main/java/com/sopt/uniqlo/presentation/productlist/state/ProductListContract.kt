package com.sopt.uniqlo.presentation.productlist.state

import androidx.compose.runtime.Immutable
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.presentation.productlist.model.ProductUiModel
import kotlinx.collections.immutable.PersistentList

@Immutable
data class ProductListState(
    val productListState: UiState<PersistentList<ProductUiModel>> = UiState.Empty,
    val selectedCategory: String = "재킷 & 블레이저",
    val totalCount: Int = 0
)

sealed interface ProductListSideEffect {
    data class ShowToast(val message: String) : ProductListSideEffect
    data class NavigateToDetail(val productId: Long) : ProductListSideEffect
}