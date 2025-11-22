package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme

//TODO("타입이 어떻게 될지 모르겠어서 서버에서 보내주는 값을 보고 수정 필요")
@Composable
fun ProductDetail(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 30.dp, bottom = 12.dp),
    ) {
        MaterialDetail()
        HorizontalDivider(thickness = 1.dp, color = UniqloTheme.colors.gray200)
        ProductDetailDescription()
        HorizontalDivider(thickness = 1.dp, color = UniqloTheme.colors.gray200)
        Inquiry()
    }
}

@Composable
@Preview(showBackground = true)
private fun ProductDetailPreview() {
    ProductDetail()
}