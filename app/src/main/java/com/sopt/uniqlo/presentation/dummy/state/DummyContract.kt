package com.sopt.uniqlo.presentation.dummy.state

import androidx.compose.runtime.Immutable
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.presentation.dummy.model.GalleryImageUiModel
import kotlinx.collections.immutable.PersistentList

@Immutable
data class DummyState(
    val galleryImageList : UiState<PersistentList<GalleryImageUiModel>> = UiState.Empty,
    val isLoadingMore : Boolean = false,
    val currentPage : Int = 1
)

sealed interface DummySideEffect {
    data class DummyErrorMessage(val msg : String) : DummySideEffect
}