package com.sopt.uniqlo.presentation.productlist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.extension.noRippleClickable
import com.sopt.uniqlo.presentation.productlist.model.ProductUiModel

@Composable
fun ProductCard(
    product: ProductUiModel,
    onItemClick: (Long) -> Unit,
    onFavoriteToggle: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .noRippleClickable { onItemClick(product.id) },
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.8f)
        )

        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ColorChipRow(product.colorHexCodes)

                Icon(
                    imageVector = ImageVector.vectorResource(
                        id = if (product.isFavorite) R.drawable.ic_heart_filled else R.drawable.ic_heart
                    ),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(22.dp)
                        .noRippleClickable { onFavoriteToggle(product.id) }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = product.genderAndSizeRange,
                    color = UniqloTheme.colors.gray300,
                    style = UniqloTheme.typography.caption.l_12
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = product.name,
                    color = UniqloTheme.colors.gray900,
                    style = UniqloTheme.typography.caption.r_12,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(10.dp))

                PriceRow(product)

                if (product.productTag != null) {
                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = product.productTag,
                        color = UniqloTheme.colors.gray600,
                        style = UniqloTheme.typography.caption.l_11,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                ReviewRow(product)
            }
        }
    }
}

@Composable
private fun ColorChipRow(hexCodes: List<String>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        hexCodes.take(4).forEach { hex ->
            Box(
                modifier = Modifier
                    .size(19.dp)
                    .background(Color(hex.toColorInt()), CircleShape)
                    .border(1.dp, UniqloTheme.colors.gray600, CircleShape)
            )
        }
    }
}

@Composable
private fun PriceRow(product: ProductUiModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (product.salePrice != null) {
            Text(
                text = product.originalPrice,
                color = UniqloTheme.colors.gray400,
                style = UniqloTheme.typography.title.m_16.copy(
                    textDecoration = TextDecoration.LineThrough
                )
            )

            Text(
                text = "원",
                color = UniqloTheme.colors.gray400,
                style = UniqloTheme.typography.title.m_16
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = product.salePrice,
                color = UniqloTheme.colors.brandRed,
                style = UniqloTheme.typography.title.m_18
            )

            Text(
                text = "원",
                color = UniqloTheme.colors.brandRed,
                style = UniqloTheme.typography.title.l_16
            )

        } else {
            Text(
                text = product.originalPrice,
                color = UniqloTheme.colors.gray900,
                style = UniqloTheme.typography.title.m_16
            )

            Text(
                text = "원",
                color = UniqloTheme.colors.gray900,
                style = UniqloTheme.typography.title.l_16
            )
        }
    }
}

@Composable
private fun ReviewRow(product: ProductUiModel) {
    val formattedRating = if (product.starAverage == product.starAverage.toInt().toFloat()) {
        product.starAverage.toInt().toString()
    } else {
        product.starAverage.toString()
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_filled),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = formattedRating,
            color = UniqloTheme.colors.gray600,
            style = UniqloTheme.typography.caption.r_9
        )

        Spacer(modifier = Modifier.width(3.dp))

        Text(
            text = "(${product.reviewCount})",
            color = UniqloTheme.colors.gray600,
            style = UniqloTheme.typography.caption.r_9
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ProductCardPreview() {
    val sampleProductSale = ProductUiModel(
        id = 1L,
        imageUrl = "",
        colorHexCodes = listOf("#222222", "#9A775B", "#234266", "#FFFFFF"),
        genderAndSizeRange = "WOMEN, XS~3XL",
        name = "밀라노립니트재킷",
        originalPrice = "49,900",
        salePrice = "39,900",
        productTag = null,
        starAverage = 5.0f,
        reviewCount = 10,
        isFavorite = true
    )
    val sampleProductNormal = ProductUiModel(
        id = 2L,
        imageUrl = "",
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

    UniqloTheme {
        Row() {
            ProductCard(
                product = sampleProductSale,
                onItemClick = {},
                onFavoriteToggle = { _ -> },
                modifier = Modifier.weight(1f)
            )
            ProductCard(
                product = sampleProductNormal,
                onItemClick = {},
                onFavoriteToggle = { _ -> },
                modifier = Modifier.weight(1f)
            )
        }
    }
}