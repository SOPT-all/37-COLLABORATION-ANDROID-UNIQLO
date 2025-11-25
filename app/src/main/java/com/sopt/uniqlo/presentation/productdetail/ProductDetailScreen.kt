package com.sopt.uniqlo.presentation.productdetail

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ProductDetailRoute(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    when (val state = uiState.productDetailUiState) {
        is UiState.Success -> {
            ProductDetailScreen(
                paddingValues = paddingValues,
                uiState = state.data,
                selectedColorName = uiState.selectedColorName,
                onColorOptionClick = viewModel::handleColorOptionClick,
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
                    "상품 정보를 불러오는데 실패했습니다: ${state.msg}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "상품 정보를 불러오지 못했습니다.")
            }
        }

        else -> {}
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductDetailScreen(
    paddingValues: PaddingValues,
    uiState: ProductInfoUiModel,
    selectedColorName: String,
    onColorOptionClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { uiState.imageUrls.size })

    Column(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxWidth()
    ) {
        // 1. 상품 이미지 갤러리
        ProductImageGallery(
            imageUrls = uiState.imageUrls,
            pagerState = pagerState,
            modifier = Modifier.fillMaxWidth()
        )

        // 2. 상품 정보 섹션
        ProductInfoSection(
            productInfo = uiState,
            selectedColor = selectedColorName,
            onColorSelected = { colorOption ->
                onColorOptionClick(colorOption.name)
            },
            modifier = Modifier.padding(vertical = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProductDetailScreen() {
    UniqloTheme {
        val dummyProduct = ProductInfoUiModel(
            name = "밀라노리브니트재킷",
            imageUrls = List(3) { "https://image.msscdn.net/thumbnails/images/goods_img/20250918/5486967/5486967_17617819130539_big.jpg?w=1200" }.toImmutableList(),
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

        ProductDetailScreen(
            uiState = dummyProduct,
            onColorOptionClick = {},
            selectedColorName = "09 BLACK",
            paddingValues = PaddingValues()
        )
    }
}