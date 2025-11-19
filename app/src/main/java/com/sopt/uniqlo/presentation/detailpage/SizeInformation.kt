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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import com.sopt.uniqlo.domain.detailpage.entity.SizeInformationEntity

@Composable
fun SizeInformation(
    modifier: Modifier = Modifier,
    sizeInformationList: List<SizeInformationEntity> = emptyList(),
) {
    Column(
        modifier = modifier.padding(vertical = 30.dp, horizontal = 16.dp),
    ) {
        Text(
            text = "사이즈 안내",
            style = UniqloTheme.typography.title.r_20
        )

        Spacer(modifier = Modifier.height(20.dp))

        val items = sizeInformationList
        items.forEachIndexed { index, data ->
            SizeInformationDetail(
                imgResource = data.imgResource,
                title = data.title,
                description = data.description,
                modifier = Modifier,
                imgDescription = null,
            )
            if (index < items.lastIndex) {
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
            painter = painterResource(id = imgResource),
            contentDescription = imgDescription,
            modifier = Modifier.size(width = 66.dp, height = 64.dp),
        )
        Spacer(modifier = modifier.width(width = 10.dp))
        Column {
            Text(
                text = title,
                style = UniqloTheme.typography.caption.sb_11
            )
            Spacer(modifier = modifier.height(height = 2.dp))
            Text(
                text = description,
                style = UniqloTheme.typography.caption.l_11,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
        Spacer(modifier = modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = UniqloTheme.colors.gray300,
            modifier = Modifier
                .padding(4.dp)
                .size(22.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SizeInformationPreview() {
    SizeInformation()
}

@Composable
@Preview(showBackground = true)
fun SizeInformationDetail() {
    SizeInformationDetail(
        imgResource = R.drawable.img_detail_page_size_chart,
        imgDescription = null,
        title = "사이즈 차트",
        description = "제품을 구매하기 전, 이전에 구매했던 제품의 사이즈와 비교해 보세요.",
        modifier = Modifier,
    )
}