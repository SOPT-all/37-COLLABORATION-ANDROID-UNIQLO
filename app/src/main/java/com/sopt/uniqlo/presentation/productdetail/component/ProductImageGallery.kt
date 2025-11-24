package com.sopt.uniqlo.presentation.productdetail.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductImageGallery(
    imageUrls: ImmutableList<String>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(3f / 4f)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            AsyncImage(
                model = imageUrls[page],
                contentDescription = "Product Image ${page + 1}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Icon(
            painter = painterResource(R.drawable.ic_style),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp, bottom = 10.dp)
                .size(32.dp)
        )

        ImageGalleryIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ImageGalleryIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val currentPage = pagerState.currentPage + 1
    val totalPages = pagerState.pageCount

    Text(
        text = "$currentPage | $totalPages",
        color = Color.White,
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier
            .background(UniqloTheme.colors.black50)
            .padding(
                horizontal = 10.dp,
                vertical = 2.5.dp
            )
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewProductImageGallery() {
    val dummyUrl =
        "https://image.msscdn.net/thumbnails/images/goods_img/20250918/5486967/5486967_17617819130539_big.jpg?w=1200"
    val dummyImageList = listOf(dummyUrl, dummyUrl, dummyUrl).toImmutableList()

    ProductImageGallery(
        imageUrls = dummyImageList,
        pagerState = rememberPagerState(pageCount = { dummyImageList.size })
    )
}