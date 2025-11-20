package com.sopt.uniqlo.presentation.category.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun CategoryList(
    categoryList: ImmutableList<String>,
    onClickCategory: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier
            .background(
                color = UniqloTheme.colors.gray100
            )
    ) {
        itemsIndexed(
            items = categoryList,
        ) { index, category ->
            CategoryListItem(
                category = category,
                onClickCategory = onClickCategory,
            )
        }
    }
}

@Composable
private fun CategoryListItem(
    category: String,
    onClickCategory: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = if (category == "아우터") {
                    UniqloTheme.colors.white
                } else {
                    UniqloTheme.colors.gray100
                }
            )
            .fillMaxWidth()
            .clickable(onClick = { onClickCategory(category) })
            .padding(horizontal = 19.dp, vertical = 9.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = category,
            style = if (category == "아우터") {
                UniqloTheme.typography.body.sb_13
            } else {
                UniqloTheme.typography.body.r_13
            },
            maxLines = 1,
            softWrap = false,
            color = UniqloTheme.colors.gray600,
            modifier = Modifier.padding(end = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryListPreview() {
    UniqloTheme {
        CategoryList(
            categoryList = listOf(
                "테스트",
                "아우터",
                "테스트",
                "테스트",
                "테스트",
                "테스트",
                "테스트",
            ).toImmutableList(),
            onClickCategory = {}
        )
    }
}