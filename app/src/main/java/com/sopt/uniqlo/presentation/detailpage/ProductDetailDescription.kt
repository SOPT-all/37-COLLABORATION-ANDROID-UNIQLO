package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.detailpage.component.TextWithLeadingIcon

@Composable
fun ProductDetailDescription(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "제품 상세 설명",
            color = UniqloTheme.colors.black,
            style = UniqloTheme.typography.body.sb_13
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(26.dp),
            modifier = Modifier,
        ) {
            Column {
                TextWithLeadingIcon(
                    text = "가디건처럼 걸쳐 입기 좋습니다.",
                )
                TextWithLeadingIcon(
                    text = "쇼트 기장으로 클린한 룩은 물론 캐주얼한 룩으로도 연출할 수 있습니다."
                )
            }
            Column(
                modifier = Modifier,
            ) {
                Text(
                    text = "기능 세부정보",
                    color = UniqloTheme.colors.black,
                    style = UniqloTheme.typography.body.r_15,
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "- 비침: 없음",
                    color = UniqloTheme.colors.black,
                    style = UniqloTheme.typography.body.r_13,
                )
                Text(
                    text = "- 핏: 보통 핏(레귤러)",
                    color = UniqloTheme.colors.black,
                    style = UniqloTheme.typography.body.r_13,
                )
                Text(
                    text = "- 포켓(주머니): 있음",
                    color = UniqloTheme.colors.black,
                    style = UniqloTheme.typography.body.r_13,
                )
            }
            Column(
                modifier = Modifier,
            ) {
                Text(
                    text = "사이즈",
                    color = UniqloTheme.colors.black,
                    style = UniqloTheme.typography.body.r_15
                )
                Spacer(modifier.height(6.dp))
                Text(
                    text = "상단 표시",
                    color = UniqloTheme.colors.black,
                    style = UniqloTheme.typography.body.r_13,
                )
            }
            Column(
                modifier = Modifier,
            ) {
                TextWithLeadingIcon(
                    text = "게재된 이미지에는 판매 예정이 없는 컬러가 포함되어 있을 수 있습니다."
                )
                TextWithLeadingIcon(
                    text = "취급 점포에 따라 상품의 품절 및 판매일 변경 될 수 있습니다."
                )
                TextWithLeadingIcon(
                    text = "모니터사양에 따라 상품의 색상 및 무늬 등이 실제 상품과 다소 차이 날 수 있습니다."
                )
                TextWithLeadingIcon(
                    text = "XS, XXL, 3XL 사이즈는 온라인 스토어에서만 판매합니다."
                )
            }
            Text(
                text = "이 제품은 동일 제품이라도 Tag에 기재된 제품 정보가 다른 경우가있습니다. 양해 부탁 드리겠습니다.",
                color = UniqloTheme.colors.black,
                style = UniqloTheme.typography.body.r_13
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ProductDetailDescriptionPreview() {
    ProductDetailDescription()
}

