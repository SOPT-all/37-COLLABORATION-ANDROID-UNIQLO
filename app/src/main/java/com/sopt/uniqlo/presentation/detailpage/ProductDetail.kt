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
import com.sopt.uniqlo.presentation.detailpage.model.DetailDescriptionModel

//TODO("타입이 어떻게 될지 모르겠어서 서버에서 보내주는 값을 보고 수정 필요")
@Composable
fun ProductDetail(
    detailDescription: DetailDescriptionModel,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 30.dp, bottom = 12.dp),
    ) {
        MaterialDetail(
            materialImageUrl = detailDescription.detailPageUrl,
            materialDescription = null,
            materialText = detailDescription.detailText
        )
        HorizontalDivider(thickness = 1.dp, color = UniqloTheme.colors.gray200)
        ProductDetailDescription(
            descriptionText = detailDescription.descriptionText,
            featureDetailText = detailDescription.featureDetailText,
            sizeDetailText = detailDescription.sizeDetailText
        )
        HorizontalDivider(thickness = 1.dp, color = UniqloTheme.colors.gray200)
        Inquiry()
    }
}

@Composable
@Preview(showBackground = true)
private fun ProductDetailPreview() {
    ProductDetail(
        detailDescription = DetailDescriptionModel(
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
        )
    )
}