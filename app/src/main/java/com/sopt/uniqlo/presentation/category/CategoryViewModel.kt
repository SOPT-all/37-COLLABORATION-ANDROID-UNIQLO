package com.sopt.uniqlo.presentation.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.uniqlo.presentation.category.state.CategorySideEffect
import com.sopt.uniqlo.presentation.category.state.CategoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(

) : ViewModel() {
    val tabList = listOf("WOMEN", "MEN", "KIDS", "BABY").toImmutableList()
    val initialCategoryList = listOf(
        "신발",
        "아우터",
        "팬츠",
        "스커트",
        "원피스",
        "이너웨어",
        "홈웨어",
        "액서세리",
        "히트택",
        "에어리즘",
        "스포츠",
        "UT",
        "콜라보",
        "브랜드",
        "신발",
        "신발",
        "신발",
        "신발",
        "신발",
        "신발",
        "신발",
    ).toImmutableList()

    private val _uiState = MutableStateFlow(
        CategoryUiState(
            categoryList = initialCategoryList,
            categoryContentList = CategoryUiState.contentData.toImmutableList()
        )
    )

    val uiState = _uiState.asStateFlow()
    private val _sideEffect = MutableSharedFlow<CategorySideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun showToast(message: String) {
        viewModelScope.launch {
            _sideEffect.emit(CategorySideEffect.ShowToast(message))
        }
    }
}