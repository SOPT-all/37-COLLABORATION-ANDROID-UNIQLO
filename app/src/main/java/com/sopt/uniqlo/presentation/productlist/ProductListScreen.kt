package com.sopt.uniqlo.presentation.productlist

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.presentation.productlist.component.ProductCard
import com.sopt.uniqlo.presentation.productlist.component.ProductCategoryTab
import com.sopt.uniqlo.presentation.productlist.component.ProductFilterBar
import com.sopt.uniqlo.presentation.productlist.component.ProductListHeader
import com.sopt.uniqlo.presentation.productlist.model.FilterChipModel
import com.sopt.uniqlo.presentation.productlist.model.ProductUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ProductListRoute(
    paddingValues: PaddingValues,
    onProductClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val categories = stringArrayResource(id = R.array.product_top_categories).toImmutableList()
    val filterNames = stringArrayResource(id = R.array.product_filters).toList()

    var filterItems: ImmutableList<FilterChipModel> by remember {
        mutableStateOf(createFilterItems(filterNames))
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    when (val state = uiState.productListState) {
        is UiState.Success -> {
            ProductListScreen(
                paddingValues = paddingValues,
                totalCount = uiState.totalCount,
                categories = categories,
                selectedTabIndex = uiState.selectedTabIndex,
                filterItems = filterItems,
                productList = state.data,
                onTabSelected = { },
                onFilterSelect = { },
                onFavoriteToggle = viewModel::onFavoriteToggle,
                onProductClick = onProductClick,
                modifier = modifier
            )
        }

        is UiState.Loading -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UiState.Failure -> {
            LaunchedEffect(Unit) {
                Toast.makeText(
                    context,
                    "상품 목록을 불러오는데 실패했습니다: ${state.msg}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "상품 목록을 불러오지 못했습니다.")
            }
        }

        else -> {}
    }
}

@Composable
fun ProductListScreen(
    paddingValues: PaddingValues,
    totalCount: Int,
    categories: List<String>,
    selectedTabIndex: Int,
    filterItems: ImmutableList<FilterChipModel>,
    productList: ImmutableList<ProductUiModel>,
    onTabSelected: (Int) -> Unit,
    onFilterSelect: (FilterChipModel) -> Unit,
    onFavoriteToggle: (Long) -> Unit,
    onProductClick: (Long) -> Unit,
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
                    selectedTabIndex = selectedTabIndex,
                    onTabSelected = onTabSelected,
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
                onProductClick = {
                    onProductClick(product.id)
                },
                onFavoriteToggle = onFavoriteToggle,
            )
        }
    }
}

private fun createFilterItems(filterNames: List<String>): ImmutableList<FilterChipModel> {
    val resetIcon = R.drawable.ic_reset
    val downArrowIcon = R.drawable.ic_filter

    return filterNames.mapIndexed { index, name ->
        val iconId = if (name == "초기화") resetIcon else downArrowIcon
        FilterChipModel(
            id = (index + 1).toLong(),
            name = name,
            icon = iconId,
            isSelected = false
        )
    }.toImmutableList()
}

@Preview(showBackground = true)
@Composable
private fun ProductListRoutePreview() {
    UniqloTheme {
        ProductListRoute(
            paddingValues = PaddingValues(0.dp),
            onProductClick = {}
        )
    }
}