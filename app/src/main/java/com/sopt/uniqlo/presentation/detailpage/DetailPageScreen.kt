package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.detailpage.component.CircleIconButton
import com.sopt.uniqlo.presentation.detailpage.component.WishListBar
import com.sopt.uniqlo.presentation.detailpage.state.DetailPageUiState

@Composable
fun DetailPageRoute(
    modifier: Modifier = Modifier,
    viewModel: DetailPageViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    DetailPageScreen(
        uiState = uiState,
        modifier = modifier
    )
}

@Composable
fun DetailPageScreen(
    uiState: DetailPageUiState,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 80.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            //제품 정보

            //탭바

            //제품 상세
            item {
                ProductDetail(
                    detailDescription = uiState.detailDescriptionList!!
                )
                HorizontalDivider(thickness = 10.dp, color = UniqloTheme.colors.gray100)
            }
            //사이즈 안내
            item {
                SizeInformation(
                    sizeInformationList = uiState.sizeInformationList,
                )
                HorizontalDivider(thickness = 10.dp, color = UniqloTheme.colors.gray100)
            }
            //스타일 힌트
            item {
                StyleHint()
                HorizontalDivider(thickness = 10.dp, color = UniqloTheme.colors.gray100)
            }
            //리뷰
        }
        //바텀바 + 플로팅 버튼
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Column{
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    CircleIconButton(
                        icon = R.drawable.ic_share,
                        onClick = {},
                        buttonSize = 40
                    )
                    CircleIconButton(
                        icon = R.drawable.ic_arrow_up,
                        onClick = {},
                        buttonSize = 40
                    )
                }
                WishListBar(
                    iconButtonClick = {},
                    wishListButtonClick = {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailPagePreview() {
    DetailPageScreen(
        uiState = DetailPageUiState()
    )
}