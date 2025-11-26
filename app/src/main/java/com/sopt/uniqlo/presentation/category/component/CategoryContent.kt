package com.sopt.uniqlo.presentation.category.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.category.model.ContentUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun CategoryContent(
    categoryContentList : ImmutableList<ContentUiModel>,
    onClickCategoryContent: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier
    ) {
        CategoryContentHeader()

        CategoryContentGrid(
            categoryContentList = categoryContentList,
            onClickCategoryContent = onClickCategoryContent,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun CategoryContentHeader(
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 27.dp, vertical = 8.dp)
    ) {
        Text(
            text = "아우터",
            style = UniqloTheme.typography.body.sb_15,
            color = UniqloTheme.colors.black
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "전체 보기",
            style = UniqloTheme.typography.caption.r_12,
            color = UniqloTheme.colors.black
        )
    }
}



@Preview
@Composable
private fun CategoryContentPreview() {
    UniqloTheme {
        CategoryContent(
            categoryContentList = listOf(
                ContentUiModel(1, R.drawable.img_category_5, "경량 패딩\n(PUFFTECH)"),
            ).toImmutableList(),
            onClickCategoryContent = {}

        )
    }
}