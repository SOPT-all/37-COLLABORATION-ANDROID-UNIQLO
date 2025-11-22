package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme

@Composable
fun MaterialDetail(
    modifier: Modifier = Modifier,
    materialImageUrl: String? = null,
    materialDescription: String? = null,
    materialText: String = "적당한 탄탄함이 느껴지는 원단을 사용하였습니다.",
) {
    Column(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(25.dp),
            modifier = Modifier,
        ) {
            Text(
                text = "제품 상세",
                color = UniqloTheme.colors.black,
                style = UniqloTheme.typography.body.sb_13
            )
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (materialImageUrl == null) {
                    Box(
                        modifier = Modifier
                            .size(width = 160.dp, height = 160.dp)
                            .background(UniqloTheme.colors.blueMain)
                    )
                } else {
                    AsyncImage(
                        model = materialImageUrl,
                        contentDescription = materialDescription,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .size(width = 160.dp, height = 160.dp)
                    )
                }
                Text(
                    text = materialText,
                    color = UniqloTheme.colors.black,
                    style = UniqloTheme.typography.caption.r_12
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MaterialDetailPreview() {
    MaterialDetail()
}