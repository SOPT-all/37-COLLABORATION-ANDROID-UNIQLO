package com.sopt.uniqlo.presentation.productdetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.presentation.productdetail.component.ProductImageGallery
import com.sopt.uniqlo.presentation.productdetail.component.ProductInfoSection
import com.sopt.uniqlo.presentation.productdetail.model.ColorOption
import com.sopt.uniqlo.presentation.productdetail.model.ProductInfoUiModel
import com.sopt.uniqlo.presentation.productdetail.state.ProductDetailState
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ProductDetailRoute(
    paddingValues: PaddingValues,
    productId: Long,
    viewModel: ProductDetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ProductDetailScreen(
        uiState = uiState,
        onColorOptionClick = viewModel::handleColorOptionClick,
        modifier = Modifier.padding(paddingValues)
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductDetailScreen(
    uiState: ProductDetailState,
    onColorOptionClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val product = (uiState.productDetailUiState as UiState.Success).data
    val pagerState = rememberPagerState(pageCount = { product.imageUrls.size })

    val selectedColorName = uiState.selectedColorName

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // 1. 상품 이미지 갤러리
        ProductImageGallery(
            imageUrls = product.imageUrls,
            pagerState = pagerState,
            modifier = Modifier.fillMaxWidth()
        )

        // 2. 상품 정보 섹션
        ProductInfoSection(
            productInfo = product,
            selectedColor = selectedColorName,
            onColorSelected = { colorOption ->
                onColorOptionClick(colorOption.name)
            },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProductDetailScreen() {
    UniqloTheme {
        val dummyProduct = ProductInfoUiModel(
            name = "밀라노리브니트재킷",
            imageUrls = List(3){"https://image.msscdn.net/thumbnails/images/goods_img/20250918/5486967/5486967_17617819130539_big.jpg?w=1200"}.toImmutableList(),
            productNumber = "479775",
            colorName = "09 BLACK",
            colorOptions = listOf(
                ColorOption("09 BLACK", Color.Black),
                ColorOption("BROWN", Color(0xFF8B7355)),
                ColorOption("NAVY", Color(0xFF1E3A5F))
            ).toImmutableList(),
            price = "49,900",
            rating = 4.8f,
            reviewCount = 24
        )

        val dummyState = ProductDetailState(
            productDetailUiState = UiState.Success(dummyProduct),
            selectedColorName = "09 BLACK"
        )

        ProductDetailScreen(
            uiState = dummyState,
            onColorOptionClick = {}
        )
    }
}