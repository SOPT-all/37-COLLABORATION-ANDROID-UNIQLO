package com.sopt.uniqlo.presentation.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.productlist.component.ProductCard
import com.sopt.uniqlo.presentation.productlist.component.ProductCategoryTab
import com.sopt.uniqlo.presentation.productlist.component.ProductFilterBar
import com.sopt.uniqlo.presentation.productlist.component.ProductListHeader
import com.sopt.uniqlo.presentation.productlist.model.FilterChipModel
import com.sopt.uniqlo.presentation.productlist.model.ProductUiModel

@Composable
fun ProductListRoute(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    val categories = stringArrayResource(id = R.array.product_top_categories).toList()
    val interactiveCategoryName = stringResource(id = R.string.product_interactive_category)
    val filterNames = stringArrayResource(id = R.array.product_filters).toList()

    var selectedCategory by remember { mutableStateOf(interactiveCategoryName) }
    val totalCount = 12
    val productList = remember { createDummyProductList() }
    val filterItems = remember { createDummyFilterItems(filterNames) }

    ProductListScreen(
        paddingValues = paddingValues,
        totalCount = totalCount,
        categories = categories,
        interactiveCategoryName = interactiveCategoryName,
        filterItems = filterItems,
        productList = productList,
        selectedCategory = selectedCategory,
        onCategorySelect = { selectedCategory = it },
        onFilterSelect = { },
        onFavoriteToggle = { id, isFav -> },
        modifier = modifier
    )

}

@Composable
fun ProductListScreen(
    paddingValues: PaddingValues,
    totalCount: Int,
    categories: List<String>,
    interactiveCategoryName: String,
    filterItems: List<FilterChipModel>,
    productList: List<ProductUiModel>,
    selectedCategory: String,
    onCategorySelect: (String) -> Unit,
    onFilterSelect: (FilterChipModel) -> Unit,
    onFavoriteToggle: (Long, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = paddingValues,
        modifier = modifier.fillMaxSize()
    ) {

        // 헤더 영역
        item(span = { GridItemSpan(2) }) {
            Column {
                // 카테고리 탭
                ProductCategoryTab(
                    categories = categories,
                    selectedCategory = selectedCategory,
                    interactiveCategoryName = interactiveCategoryName,
                    onCategorySelected = onCategorySelect
                )

                // 필터 바
                ProductFilterBar(
                    filterItems = filterItems,
                    onFilterItemClick = onFilterSelect
                )

                // 상품 개수 헤더
                ProductListHeader(
                    totalCount = totalCount
                )
            }
        }

        // 상품 목록
        items(
            items = productList,
            key = { it.id }
        ) { product ->
            ProductCard(
                product = product,
                onItemClick = { /* 상세 페이지 이동 */ },
                onFavoriteToggle = onFavoriteToggle,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

private fun createDummyFilterItems(filterNames: List<String>): List<FilterChipModel> {
    val resetIcon = R.drawable.ic_reset
    val downArrowIcon = R.drawable.ic_filter

    return filterNames.map { name ->
        val iconId = if (name == "초기화") resetIcon else downArrowIcon
        FilterChipModel(
            name = name,
            icon = iconId,
            isSelected = false
        )
    }
}

private fun createDummyProductList(): List<ProductUiModel> {
    return listOf(
        ProductUiModel(
            id = 1L,
            imageUrl = "https://image.msscdn.net/thumbnails/images/goods_img/20250918/5486967/5486967_17617819130539_big.jpg?w=1200",
            colorHexCodes = listOf("#000000", "#111111", "#222222", "#FFFFFF"),
            genderAndSizeRange = "WOMEN, XS~3XL",
            name = "밀라노립니트재킷",
            originalPrice = "49,900",
            salePrice = "39,900",
            productTag = "온라인단독",
            starAverage = 5.0f,
            reviewCount = 10,
            isFavorite = true
        ),
        ProductUiModel(
            id = 2L,
            imageUrl = "https://image.msscdn.net/thumbnails/images/goods_img/20250918/5488701/5488701_17617818112680_big.jpg?w=1200",
            colorHexCodes = listOf("#828388", "#303030", "#3D2D2D"),
            genderAndSizeRange = "WOMEN, XS~XXL",
            name = "더블브레스트재킷(셋업가능)",
            originalPrice = "89,900",
            salePrice = null,
            productTag = "일부매장제품",
            starAverage = 4.6f,
            reviewCount = 3,
            isFavorite = false
        )
    ) + List(18) { id ->
        ProductUiModel(
            id = id + 3L,
            imageUrl = "https://image.msscdn.net/thumbnails/images/goods_img/20250808/5303307/5303307_17569422514451_big.jpg?w=1200",
            colorHexCodes = listOf("#000000", "#111111"),
            genderAndSizeRange = "MEN, S~3XL",
            name = "베이직 티셔츠 ${id + 3}",
            originalPrice = "29,900",
            salePrice = null,
            productTag = null,
            starAverage = 4.2f,
            reviewCount = 100 + id,
            isFavorite = false
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProductListRoutePreview() {
    UniqloTheme {
        ProductListRoute(paddingValues = PaddingValues(0.dp))
    }
}