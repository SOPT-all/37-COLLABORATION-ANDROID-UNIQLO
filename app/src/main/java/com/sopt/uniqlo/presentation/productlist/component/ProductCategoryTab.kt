package com.sopt.uniqlo.presentation.productlist.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme

@Composable
fun ProductCategoryTab(
    categories: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (index: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    SecondaryScrollableTabRow(
        modifier = modifier
            .fillMaxWidth(),
        containerColor = UniqloTheme.colors.white,
        selectedTabIndex = selectedTabIndex,
        edgePadding = 0.dp,
        indicator = {
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(
                    selectedTabIndex = selectedTabIndex
                ),
                color = UniqloTheme.colors.black
            )
        }
    ) {
        categories.forEachIndexed { index, title ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = title,
                        style = UniqloTheme.typography.caption.m_12,
                        color = if (index == selectedTabIndex) {
                            UniqloTheme.colors.black
                        } else {
                            UniqloTheme.colors.gray400
                        },
                        modifier = Modifier.padding(top = 14.dp, bottom = 13.dp)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCategoryTabPreview() {
    val sampleCategories = listOf(
        "경량 패딩(PUFF TECH)", "파카&블루종&후리스", "재킷 & 블레이저", "코트", "다운&패딩"
    )
    var selectedTabIndex by remember { mutableIntStateOf(2) }

    ProductCategoryTab(
        categories = sampleCategories,
        selectedTabIndex = selectedTabIndex,
        onTabSelected = { newIndex ->
            selectedTabIndex = newIndex
        }
    )
}