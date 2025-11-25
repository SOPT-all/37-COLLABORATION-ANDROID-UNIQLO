package com.sopt.uniqlo.presentation.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.domain.productlist.usecase.GetProductListUseCase
import com.sopt.uniqlo.presentation.productlist.model.toUiModel
import com.sopt.uniqlo.presentation.productlist.state.ProductListSideEffect
import com.sopt.uniqlo.presentation.productlist.state.ProductListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductListUseCase: GetProductListUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProductListState())
    val uiState: StateFlow<ProductListState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<ProductListSideEffect>()
    val sideEffect: SharedFlow<ProductListSideEffect> = _sideEffect.asSharedFlow()

    private val favoriteMap: MutableMap<Long, Boolean> = mutableMapOf()

    init {
        loadProductList()
    }

    private fun loadProductList() {
        _uiState.update {
            it.copy(
                productListState = UiState.Loading
            )
        }
        viewModelScope.launch {
            getProductListUseCase()
                .onSuccess { data ->
                    _uiState.update { state ->
                        val uiModels = data.toUiModel(favoriteMap)

                        state.copy(
                            productListState = UiState.Success(uiModels),
                            selectedTabIndex = 2,
                            totalCount = uiModels.size
                        )
                    }
                }
                .onFailure { failure ->
                    _uiState.update {
                        it.copy(
                            productListState = UiState.Failure(failure.message ?: "")
                        )
                    }
                }
        }
    }

    fun onFavoriteToggle(id: Long){
        val state = _uiState.value.productListState
        if (state is UiState.Success){
            val isCurrentFavorite = favoriteMap[id] ?: false
            favoriteMap[id] = !isCurrentFavorite

            val updatedList = state.data.map {
                if (it.id == id) {
                    it.copy(isFavorite = !it.isFavorite)
                } else {
                    it
                }
            }.toImmutableList()

            _uiState.update {
                it.copy(
                    productListState = UiState.Success(updatedList)
                )
            }
        }
    }
}