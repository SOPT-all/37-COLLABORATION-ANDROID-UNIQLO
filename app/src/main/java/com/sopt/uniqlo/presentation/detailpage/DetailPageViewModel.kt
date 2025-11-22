package com.sopt.uniqlo.presentation.detailpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.uniqlo.R
import com.sopt.uniqlo.presentation.detailpage.model.DetailDescriptionModel
import com.sopt.uniqlo.presentation.detailpage.model.SizeInformationItemModel
import com.sopt.uniqlo.presentation.detailpage.state.DetailPageUiState
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
class DetailPageViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(DetailPageUiState())
    val uiState: StateFlow<DetailPageUiState> = _uiState.asStateFlow()
    val sizeInformationDummyList = listOf(
        SizeInformationItemModel(
            imgResource = R.drawable.img_detail_page_size_chart,
            title = "사이즈 차트",
            description = "제품을 구매하기 전, 이전에 구매했던 제품의 사이즈와 비교해 보세요.",
        ),
        SizeInformationItemModel(
            imgResource = R.drawable.img_detail_page_stature_guide,
            title = "신장별 착용 가이드",
            description = "신장에 따른 제품의 전체 길이를 확인해 보세요."
        ),
        SizeInformationItemModel(
            imgResource = R.drawable.img_detail_page_size_assist,
            title = "마이 사이즈 어시스트",
            description = "치수를 간단히 입력하거나 카메라 캡처를 통해 권장 사이즈를 확인해 보세요."
        ),
        SizeInformationItemModel(
            imgResource = R.drawable.img_detail_page_styling,
            title = "신장별 스타일링",
            description = "나와 비슷한 체형의 고객이 착용한 사이즈를 확인해 보세요."
        )
    )

    init {
        setSizeInformationDummyList()
    }

    fun setSizeInformationDummyList(){
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    sizeInformationList = sizeInformationDummyList
                )
            }
        }
    }
}