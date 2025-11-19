package com.sopt.uniqlo.presentation.detailpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.uniqlo.domain.detailpage.usecase.GetSizeInformationDummyListUseCase
import com.sopt.uniqlo.presentation.detailpage.model.DetailPageUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailPageViewModel @Inject constructor(
    private val getSizeInformationDummyListUseCase: GetSizeInformationDummyListUseCase,
) : ViewModel() {
    private val _detailPageUiState = MutableStateFlow(DetailPageUiState())
    val detailPageUiState: StateFlow<DetailPageUiState> = _detailPageUiState.asStateFlow()

    init {
        setSizeInformationDummyList()
    }

    fun setSizeInformationDummyList(){
        viewModelScope.launch {
            val sizeInformationList = getSizeInformationDummyListUseCase()
            _detailPageUiState.update {
                it.copy(
                    sizeInformationList = sizeInformationList
                )
            }
        }
    }
}