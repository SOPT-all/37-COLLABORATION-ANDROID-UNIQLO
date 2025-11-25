package com.sopt.uniqlo.presentation.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.domain.productdetail.usecase.GetProductDetailUseCase
import com.sopt.uniqlo.presentation.productdetail.model.toUiModel
import com.sopt.uniqlo.presentation.productdetail.state.ProductDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProductDetailState())
    val uiState: StateFlow<ProductDetailState> = _uiState.asStateFlow()

    private val productId: Long = savedStateHandle["productId"] ?: 1L

    init {
        loadProductDetail(productId)
    }

    private fun loadProductDetail(productId: Long) {
        viewModelScope.launch {
            getProductDetailUseCase(productId)
                .onSuccess { productDetailEntity ->
                    val uiModel = productDetailEntity.toUiModel()
                    _uiState.update {
                        it.copy(
                            productDetailUiState = UiState.Success(uiModel),
                            selectedColorName = uiModel.colorName
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            productDetailUiState = UiState.Failure(throwable.message ?: "상품 정보를 불러오지 못했습니다."),
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