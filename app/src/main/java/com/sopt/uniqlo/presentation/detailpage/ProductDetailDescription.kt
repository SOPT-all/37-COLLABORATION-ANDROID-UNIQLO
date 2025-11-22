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
    descriptionText: List<String> = emptyList(),
    featureDetailText: List<String> = emptyList(),
    sizeDetailText: List<String> = emptyList(),
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
                descriptionText.forEach { text ->
                    TextWithLeadingIcon(
                        text = text
                    )
                }
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
                featureDetailText.forEach { text ->
                    Text(
                        text = "- $text",
                        color = UniqloTheme.colors.black,
                        style = UniqloTheme.typography.body.r_13,
                    )
                }
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
                sizeDetailText.forEach { text ->
                    TextWithLeadingIcon(
                        text = text
                    )
                }
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

