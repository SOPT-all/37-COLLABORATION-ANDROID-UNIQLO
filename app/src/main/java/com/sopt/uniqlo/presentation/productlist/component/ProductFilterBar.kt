package com.sopt.uniqlo.presentation.productlist.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.productlist.model.FilterChipModel

@Composable
fun ProductFilterBar(
    filterItems: List<FilterChipModel>,
    onFilterItemClick: (FilterChipModel) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 13.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(filterItems, key = { it.name }) { item ->
            FilterChip(
                item = item,
                onClick = { onFilterItemClick(item) }
            )
        }
    }
}


@Composable
private fun FilterChip(
    item: FilterChipModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .border(
                1.dp,
                UniqloTheme.colors.gray300,
                RoundedCornerShape(21.dp)
            )
            .padding(horizontal = 6.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = item.name,
            color = UniqloTheme.colors.gray900,
            style = UniqloTheme.typography.caption.m_12
        )

        Spacer(modifier = Modifier.width(4.dp))

        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            tint = UniqloTheme.colors.black
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductFilterBarPreview() {
    val resetIcon = R.drawable.ic_reset
    val downArrowIcon = R.drawable.ic_filter

    val sampleItems = remember {
        listOf(
            FilterChipModel(name = "초기화", icon = resetIcon, isSelected = false),
            FilterChipModel(name = "인기순", icon = downArrowIcon, isSelected = false),
            FilterChipModel(name = "카테고리", icon = downArrowIcon, isSelected = false),
            FilterChipModel(name = "가격", icon = downArrowIcon, isSelected = false),
            FilterChipModel(name = "색상", icon = downArrowIcon, isSelected = false),
            FilterChipModel(name = "사이즈", icon = downArrowIcon, isSelected = false),
        )
    }

    ProductFilterBar(
        filterItems = sampleItems,
        onFilterItemClick = { }
    )
}