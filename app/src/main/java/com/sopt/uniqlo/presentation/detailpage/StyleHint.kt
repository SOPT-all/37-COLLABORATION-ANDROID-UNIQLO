package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import com.sopt.uniqlo.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.extension.noRippleClickable
import com.sopt.uniqlo.presentation.detailpage.component.ReadMoreButton
import com.sopt.uniqlo.presentation.detailpage.model.StyleHintModel

@Composable
fun StyleHint(
    styleHintList: List<StyleHintModel>,
    onLikedClick: (Int) -> Unit,
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
                items = styleHintList
            ) { styleHint ->
                StyleHintItem(
                    imgUrl = styleHint.imgUrl,
                    isLiked = styleHint.isLiked,
                    onLikedClick = { onLikedClick(styleHint.id) }
                )
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
private fun StyleHintItem(
    onLikedClick: () -> Unit,
    modifier: Modifier = Modifier,
    imgUrl: String? = null,
    isLiked: Boolean = false,
) {
    //TODO("이미지 받으면서 AsyncImage 사용 필요")
    Box(
        modifier = modifier
            .size(height = 240.dp, width = 148.dp)
            .background(
                color = if (imgUrl.isNullOrBlank()) UniqloTheme.colors.blueMain else Color.Unspecified
            )
    ) {
        if (!imgUrl.isNullOrBlank()) {
            AsyncImage(
                model = imgUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
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
                .size(44.dp)
                .padding(11.dp)
                .noRippleClickable(onLikedClick)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun StyleHintPreview() {
    StyleHint(
        styleHintList = listOf(
            StyleHintModel(
                imgUrl = "",
                isLiked = false,
            ),
            StyleHintModel(
                imgUrl = "",
                isLiked = true,
            ), StyleHintModel(
                imgUrl = "",
                isLiked = true,
            )
        ),
        onLikedClick = {}
    )
}

@Composable
@Preview(showBackground = true)
private fun StyleHintItemPreview() {
    StyleHintItem(
        imgUrl = "",
        onLikedClick = {}
    )
}

@Composable
@Preview(showBackground = true)
private fun StyleHintItemIsLikedPreview() {
    StyleHintItem(
        imgUrl = null,
        isLiked = true,
        onLikedClick = {}
    )
}