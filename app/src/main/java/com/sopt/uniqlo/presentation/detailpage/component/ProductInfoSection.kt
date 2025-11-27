package com.sopt.uniqlo.presentation.detailpage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.extension.noRippleClickable
import com.sopt.uniqlo.presentation.detailpage.model.ColorOption
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ProductInfoSection(
    name: String,
    productNumber: String,
    price: String,
    rating: Float,
    reviewCount: Int,
    colorOptions: ImmutableList<ColorOption>,
    selectedColor: String,
    onColorSelected: (ColorOption) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.5.dp)
    ) {
        Text(
            text = name,
            color = UniqloTheme.colors.black,
            style = UniqloTheme.typography.title.r_20
        )

        Text(
            text = "제품 번호:${productNumber}",
            color = UniqloTheme.colors.gray600,
            style = UniqloTheme.typography.body.r_13
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "컬러: $selectedColor",
            color = UniqloTheme.colors.gray300,
            style = UniqloTheme.typography.caption.r_12
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            colorOptions.forEach { colorOption ->
                ColorCircle(
                    color = colorOption.color,
                    isSelected = selectedColor == colorOption.name,
                    onClick = {
                        onColorSelected(colorOption)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Text(
                    text = price,
                    color = UniqloTheme.colors.gray900,
                    style = UniqloTheme.typography.title.sb_26
                )

                Text(
                    text = "원",
                    color = UniqloTheme.colors.gray900,
                    style = UniqloTheme.typography.title.m_24
                )
            }

            RatingSection(
                rating = rating,
                reviewCount = reviewCount
            )
        }
    }
}

@Composable
private fun ColorCircle(
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(41.dp)
            .border(
                width = if (isSelected) 1.dp else 0.dp,
                color = if (isSelected) UniqloTheme.colors.black else Color.Transparent,
                shape = CircleShape
            )
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
                .background(color = color)
                .then(
                    if (color == UniqloTheme.colors.white) {
                        Modifier.border(1.dp, UniqloTheme.colors.black, CircleShape)
                    } else {
                        Modifier
                    }
                )
        )
    }
}

@Composable
private fun RatingSection(
    rating: Float,
    reviewCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(5) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_star_filled),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(16.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))
        }

        Text(
            text = rating.toString(),
            color = UniqloTheme.colors.black,
            style = UniqloTheme.typography.body.sb_15
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(
            text = "($reviewCount)",
            color = UniqloTheme.colors.blueMain,
            style = UniqloTheme.typography.body.r_13
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProductInfoSection() {
    ProductInfoSection(
        name = "밀라노리니트재킷",
        productNumber = "479775",
        colorOptions = listOf(
            ColorOption("Black", Color.Black),
            ColorOption("Brown", Color(0xFF8B7355)),
            ColorOption("Navy", Color(0xFF1E3A5F))
        ).toImmutableList(),
        price = "49,900",
        rating = 4.8f,
        reviewCount = 24,
        selectedColor = "Black",
        onColorSelected = {}
    )
}