package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.detailpage.component.IconTextButton
import com.sopt.uniqlo.presentation.detailpage.component.TextWithLeadingIcon
import com.sopt.uniqlo.presentation.detailpage.model.DetailDescriptionModel

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
            materialImageUrl = detailDescription.detailPageUrl.firstOrNull(),
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
        Inquiry(
            onClick = {}
        )
    }
}

@Composable
private fun MaterialDetail(
    modifier: Modifier = Modifier,
    materialImageUrl: String? = null,
    materialDescription: String? = null,
    materialText: String = "적당한 탄탄함이 느껴지는 원단을 사용하였습니다.",
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(25.dp),
        modifier = modifier,
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
            if (materialImageUrl.isNullOrBlank()) {
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

@Composable
private fun ProductDetailDescription(
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
            Column {
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
            Column {
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
            Column{
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
private fun Inquiry(
    onClick: () -> Unit,
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
                    title = "문의하기",
                    onClick = onClick
                )
            }
        }
    }
}

//프리뷰
@Composable
@Preview(showBackground = true)
private fun ProductDetailPreview() {
    ProductDetail(
        detailDescription = DetailDescriptionModel(
            detailPageUrl = emptyList(),
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

@Preview(showBackground = true)
@Composable
private fun MaterialDetailPreview() {
    MaterialDetail()
}

@Composable
@Preview(showBackground = true)
private fun ProductDetailDescriptionPreview() {
    ProductDetailDescription()
}


@Composable
@Preview(showBackground = true)
private fun InquiryPreview() {
    Inquiry(
        onClick = {}
    )
}