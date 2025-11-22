package com.sopt.uniqlo.presentation.detailpage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import com.sopt.uniqlo.R

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.detailpage.component.ReadMoreButton

@Composable
fun StyleHint(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(vertical = 20.dp, horizontal = 16.dp)
    ) {
        Text(
            text = "StyleHint",
            color = UniqloTheme.colors.black,
            style = UniqloTheme.typography.title.r_20
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow {
            items(
                count = 5,
            ) {
                StyleHintItem()
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        ReadMoreButton(
            text = "스타일링",
            onClick = {},
            modifier = Modifier,
        )
    }
}

@Composable
fun StyleHintItem(
    modifier: Modifier = Modifier,
    @DrawableRes imgResource: Int? = null,
    isLiked: Boolean = false,
) {
    //TODO("이미지 받으면서 AsyncImage 사용 필요")
    Box(
        modifier = modifier
            .size(height = 240.dp, width = 148.dp)
            .background(
                color = if (imgResource == null) UniqloTheme.colors.blueMain else Color.Unspecified
            )
    ) {
        Icon(
            imageVector = if (!isLiked) {
                ImageVector.vectorResource(R.drawable.ic_heart)
            } else {
                ImageVector.vectorResource(R.drawable.ic_heart_filled)
            },
            contentDescription = null,
            tint = UniqloTheme.colors.black,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(36.dp)
                .padding(4.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun StyleHintPreview() {
    StyleHint()
}

@Composable
@Preview(showBackground = true)
private fun StyleHintItemPreview() {
    StyleHintItem(
        imgResource = null
    )
}

@Composable
@Preview(showBackground = true)
private fun StyleHintItemIsLikedPreview() {
    StyleHintItem(
        imgResource = null,
        isLiked = true
    )
}