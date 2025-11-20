package com.sopt.uniqlo.presentation.productlist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme

@Composable
fun ProductCategoryTab(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    interactiveCategoryName: String,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items(
            categories,
            key = { it }
        ) { category ->
            val isSelected = category == selectedCategory
            val isInteractive = category == interactiveCategoryName
            val lineColor = if (isSelected) UniqloTheme.colors.black else UniqloTheme.colors.gray100
            val textColor = if (isSelected) UniqloTheme.colors.black else UniqloTheme.colors.gray400
            val textStyle =
                if (isSelected) UniqloTheme.typography.reddit.caption_sb_12 else UniqloTheme.typography.reddit.caption_m_12

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        enabled = isInteractive,
                        onClick = { onCategorySelected(category) }
                    )
                    .drawBehind {
                        val strokeWidth = 1.dp.toPx()
                        val y = size.height - strokeWidth / 2

                        drawLine(
                            color = lineColor,
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = strokeWidth
                        )
                    }
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = category,
                    color = textColor,
                    style = textStyle,
                    modifier = Modifier.padding(top = 14.dp, bottom = 13.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProductCategoryTabPreview() {
    val sampleCategories = listOf(
        "경량 패딩(PUFF TECH)", "파카&블루종&후리스", "재킷 & 블레이저", "코트", "다운&패딩"
    )
    var selected by remember { mutableStateOf("재킷 & 블레이저") }

    ProductCategoryTab(
        categories = sampleCategories,
        selectedCategory = selected,
        onCategorySelected = { newCategory ->
            selected = newCategory
        },
        interactiveCategoryName = "재킷 & 블레이저"
    )
}
