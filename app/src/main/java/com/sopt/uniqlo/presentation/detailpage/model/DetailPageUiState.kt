package com.sopt.uniqlo.presentation.detailpage.model

import com.sopt.uniqlo.domain.detailpage.entity.SizeInformationEntity

data class DetailPageUiState (
    val sizeInformationList: List<SizeInformationEntity> = emptyList(),
    val isLoading: Boolean = false,
)