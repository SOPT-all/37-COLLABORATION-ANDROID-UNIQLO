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
import com.sopt.uniqlo.presentation.detailpage.model.DetailDescriptionModel
import com.sopt.uniqlo.presentation.detailpage.model.SizeInformationItemModel
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
        uiState = DetailPageUiState(
            detailDescriptionList = DetailDescriptionModel(
                detailPageUrl = null,
                detailText = "적당한 탄탄함이 느껴지는 원단을 사용하였습니다.",
                descriptionText = listOf(
                    "가디건처럼 걸쳐 입기 좋습니다.",
                    "쇼트 기장으로 클린한 룩은 물론 캐주얼한 룩으로도 연출할 수 있습니다."
                ),
                featureDetailText = listOf(
                    "비침: 없음",
                    "핏: 보통 핏(레귤러)",
                    "포켓(주머니): 있음"
                ),
                sizeDetailText = listOf(
                    "게재된 이미지에는 판매 예정이 없는 컬러가 포함되어 있을 수 있습니다.",
                    "취급 점포에 따라 상품의 품절 및 판매일 변경 될 수 있습니다.",
                    "모니터사양에 따라 상품의 색상 및 무늬 등이 실제 상품과 다소 차이 날 수 있습니다.",
                    "XS, XXL, 3XL 사이즈는 온라인 스토어에서만 판매합니다."
                )
            ),
            sizeInformationList = listOf(
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
        )
    )
}