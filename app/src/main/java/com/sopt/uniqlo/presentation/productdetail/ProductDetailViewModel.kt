package com.sopt.uniqlo.presentation.productdetail

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.presentation.productdetail.model.ColorOption
import com.sopt.uniqlo.presentation.productdetail.model.ProductInfoUiModel
import com.sopt.uniqlo.presentation.productdetail.state.ProductDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ProductDetailState())
    val uiState: StateFlow<ProductDetailState> = _uiState.asStateFlow()

    init {
        loadProductDetail(productId = 1234L)
    }

    private fun loadProductDetail(productId: Long) {
        viewModelScope.launch {

            val dummyData = getDummyProductDetail(productId)

            if (dummyData != null) {
                _uiState.update {
                    it.copy(
                        productDetailUiState = UiState.Success(dummyData),
                        selectedColorName = dummyData.colorName
                    )
                }
            } else {
                _uiState.update {
                    it.copy(
                        productDetailUiState = UiState.Failure("상품 정보를 찾을 수 없습니다: $productId"),
                    )
                }
            }
        }
    }

    fun handleColorOptionClick(colorName: String) {
        _uiState.update {
            it.copy(
                selectedColorName = colorName,
            )
        }
    }
}

private fun getDummyProductDetail(productId: Long): ProductInfoUiModel? {
    return ProductInfoUiModel(
        imageUrls = List(3){"https://image.msscdn.net/thumbnails/images/goods_img/20250918/5486967/5486967_17617819130539_big.jpg?w=1200"}.toImmutableList(),
        name = "밀라노리브니트재킷",
        productNumber = "479775",
        colorName = "09 BLACK",
        colorOptions = listOf(
            ColorOption("09 BLACK", Color.Black),
            ColorOption("08 BROWN", Color(0xFF8B7355)),
            ColorOption("07 NAVY", Color(0xFF1E3A8A)),
            ColorOption("06 RED", Color(0xFFC80000))
        ).toImmutableList(),
        price = "59,900",
        rating = 5.0f,
        reviewCount = 100
    )
}