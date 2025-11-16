package com.sopt.uniqlo.presentation.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.domain.dummy.usecase.GetGalleryImageListUseCase
import com.sopt.uniqlo.presentation.dummy.model.toUiModel
import com.sopt.uniqlo.presentation.dummy.state.DummySideEffect
import com.sopt.uniqlo.presentation.dummy.state.DummyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
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
class DummyViewModel @Inject constructor(
    private val getGalleryImageListUseCase: GetGalleryImageListUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(DummyState())
    val uiState : StateFlow<DummyState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<DummySideEffect>()
    val sideEffect : SharedFlow<DummySideEffect> = _sideEffect.asSharedFlow()

    init {
        getInitGalleryImageList(_uiState.value.currentPage, 30)
    }

    fun getInitGalleryImageList(page : Int, limit : Int) {
        _uiState.update {
            it.copy(
                galleryImageList = UiState.Loading
            )
        }

        viewModelScope.launch {
            getGalleryImageListUseCase(page, limit)
                .onSuccess { data ->
                    _uiState.update { state ->
                        state.copy(
                            galleryImageList = UiState.Success(
                                data.map { it.toUiModel() }.toPersistentList()
                            ),
                            isLoadingMore = false
                        )
                    }
                }
                .onFailure { failure ->
                    _uiState.update {
                        it.copy(
                            galleryImageList = UiState.Failure(failure.message ?: ""),
                            isLoadingMore = false
                        )
                    }
                }
        }
    }

}