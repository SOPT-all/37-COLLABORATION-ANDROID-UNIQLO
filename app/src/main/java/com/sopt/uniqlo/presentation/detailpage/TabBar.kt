package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.extension.noRippleClickable

enum class TabState(val title: String) {
    TOP(
        title = "top"
    ),
    DETAIL(
        title = "제품 상세",
    ),
    SIZE(
        title = "사이즈 안내",
    ),
    STYLE(
        title = "스타일 힌트",
    ),
    REVIEW(
        title = "리뷰",
    )
}

@Composable
fun TabBar(
    tabState: TabState = TabState.TOP,
    onTabSelected: (TabState) -> Unit
) {
    val displayTab = if(tabState == TabState.TOP) TabState.DETAIL else tabState

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TabState.entries.filter { it != TabState.TOP }.forEach { state ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(
                        color = if (displayTab == state) UniqloTheme.colors.white else UniqloTheme.colors.gray100
                    )
                    .padding(vertical = 14.dp)
                    .noRippleClickable(
                        onClick = { onTabSelected(state) }
                    )
            ) {
                Text(
                    text = state.title,
                    color = if (displayTab == state) UniqloTheme.colors.black else UniqloTheme.colors.gray400,
                    style = UniqloTheme.typography.caption.m_12,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun TabBarPreview() {
    TabBar(
        onTabSelected = {}
    )
}