package com.sopt.uniqlo.presentation.detailpage.state

import com.sopt.uniqlo.presentation.detailpage.model.DetailDescriptionModel
import com.sopt.uniqlo.presentation.detailpage.model.SizeInformationItemModel

data class DetailPageUiState (
    val detailDescriptionList: DetailDescriptionModel? = null,
    val sizeInformationList: List<SizeInformationItemModel> = emptyList(),
    val isLoading: Boolean = false,
)