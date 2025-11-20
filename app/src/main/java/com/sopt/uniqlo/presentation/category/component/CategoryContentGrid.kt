package com.sopt.uniqlo.presentation.category.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.extension.noRippleClickable
import com.sopt.uniqlo.presentation.category.model.ContentUiModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun CategoryContentGrid(
    categoryContentList : ImmutableList<ContentUiModel>,
    onClickCategoryContent: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(23.dp),
        verticalArrangement = Arrangement.spacedBy(19.dp)
    ) {
        items(
            categoryContentList.size
        ) { item ->
            GridItem(
                item = categoryContentList[item],
                onItemClick = onClickCategoryContent
            )
        }
    }
}
@Composable
private fun GridItem(
    item: ContentUiModel,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier
            .noRippleClickable(onClick = { onItemClick(item.id) }),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(item.image),
            contentDescription = null
        )

        Text(
            text = item.title,
            style = UniqloTheme.typography.caption.l_10,
            color = UniqloTheme.colors.black,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun GridPreview() {
    UniqloTheme {
        GridItem(
            item = ContentUiModel(1, R.drawable.img_category_5, "경량 패딩\n(PUFFTECH)"),
            onItemClick = {}
        )
    }
}