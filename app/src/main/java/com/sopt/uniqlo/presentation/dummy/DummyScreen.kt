package com.sopt.uniqlo.presentation.dummy

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DummyRoute(
    viewModel: DummyViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    // 뷰 구성
    DummyScreen(

    )
}

@Composable
private fun DummyScreen(

) {

}