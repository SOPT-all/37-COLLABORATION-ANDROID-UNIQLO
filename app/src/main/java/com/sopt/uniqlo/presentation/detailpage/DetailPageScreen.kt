package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.uniqlo.presentation.detailpage.model.DetailPageUiState

@Composable
fun DetailPageRoute(
    modifier: Modifier = Modifier,
    viewModel: DetailPageViewModel = viewModel(),
) {
    val uiState by viewModel.detailPageUiState.collectAsStateWithLifecycle()

    DetailPageScreen(
        detailPageUiState = uiState,
        modifier = modifier
    )
}

@Composable
fun DetailPageScreen(
    detailPageUiState: DetailPageUiState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        //탑바

        //제품 정보

        //탭바

        //제품 상세
        //사이즈 안내
        item {
            SizeInformation(
                sizeInformationList = detailPageUiState.sizeInformationList,
                modifier = Modifier
            )
        }
        //스타일 힌트

        //리뷰

        //바텀바 + 플로팅 버튼

    }
}

@Preview(showBackground = true)
@Composable
fun DetailPagePreview() {
    DetailPageScreen(
        detailPageUiState = DetailPageUiState()
    )
}