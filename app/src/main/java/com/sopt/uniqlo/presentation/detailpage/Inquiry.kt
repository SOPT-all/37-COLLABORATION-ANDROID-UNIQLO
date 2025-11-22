package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.detailpage.component.IconTextButton

@Composable
fun Inquiry(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier,
    ) {
        Column {
            Text(
                text = "배송 / 결제 / 교환 / 반품",
                color = UniqloTheme.colors.black,
                style = UniqloTheme.typography.body.sb_13
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "상세 정보는 각 링크에서 확인 부탁 드립니다.",
                color = UniqloTheme.colors.black,
                style = UniqloTheme.typography.body.r_15
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier
        ) {
            Text(
                text = "배송 / 결제 정보",
                color = UniqloTheme.colors.blueMain,
                style = UniqloTheme.typography.body.r_13
            )
            Text(
                text = "교환 / 반품 안내",
                color = UniqloTheme.colors.blueMain,
                style = UniqloTheme.typography.body.r_13
            )
            Row {
                Spacer(modifier = Modifier.weight(1f))
                IconTextButton(
                    imgResource = R.drawable.ic_inquiry,
                    imgDescription = "문의하기 버튼",
                    title = "문의하기"
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun InquiryPreview() {
    Inquiry()
}