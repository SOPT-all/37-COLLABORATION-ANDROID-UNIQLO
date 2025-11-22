package com.sopt.uniqlo.presentation.detailpage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.sopt.uniqlo.presentation.detailpage.model.SizeInformationItemModel

@Composable
fun SizeInformation(
    sizeInformationList: List<SizeInformationItemModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(vertical = 30.dp, horizontal = 16.dp),
    ) {
        Text(
            text = "사이즈 안내",
            style = UniqloTheme.typography.title.r_20,
            color = UniqloTheme.colors.black
        )

        Spacer(modifier = Modifier.height(20.dp))

        sizeInformationList.forEachIndexed { index, data ->
            SizeInformationDetail(
                imgResource = data.imgResource,
                title = data.title,
                description = data.description,
                imgDescription = null,
            )
            if (index < sizeInformationList.lastIndex) {
                HorizontalDivider(thickness = 1.dp, color = UniqloTheme.colors.gray200)
            }
        }
    }
}

@Composable
fun SizeInformationDetail(
    @DrawableRes imgResource: Int,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    imgDescription: String? = null,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = imgResource),
            contentDescription = imgDescription,
            modifier = Modifier.size(width = 66.dp, height = 64.dp),
        )
        Spacer(modifier = Modifier.width(width = 10.dp))
        Column {
            Text(
                text = title,
                color = UniqloTheme.colors.black,
                style = UniqloTheme.typography.caption.sb_11,
            )
            Spacer(modifier = Modifier.height(height = 2.dp))
            Text(
                text = description,
                color = UniqloTheme.colors.black,
                style = UniqloTheme.typography.caption.l_11,
                modifier = Modifier.fillMaxWidth(0.8f),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
            tint = UniqloTheme.colors.gray300,
            modifier = Modifier
                .padding(4.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun SizeInformationPreview() {
    SizeInformation(
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
}

@Composable
@Preview(showBackground = true)
private fun SizeInformationDetail() {
    SizeInformationDetail(
        imgResource = R.drawable.img_detail_page_size_chart,
        imgDescription = null,
        title = "사이즈 차트",
        description = "제품을 구매하기 전, 이전에 구매했던 제품의 사이즈와 비교해 보세요.",
        modifier = Modifier,
    )
}