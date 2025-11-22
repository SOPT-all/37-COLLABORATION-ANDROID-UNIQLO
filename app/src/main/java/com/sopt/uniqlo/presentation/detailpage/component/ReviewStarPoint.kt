package com.sopt.uniqlo.presentation.detailpage.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme

@Composable
fun ReviewStarPoint(
    starPoint: Int,
    modifier: Modifier = Modifier,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(starPoint) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_filled),
                contentDescription = null,
                tint = UniqloTheme.colors.black,
                modifier = Modifier
                    .size(18.dp)
            )
        }
        repeat(5 - starPoint) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_gray),
                contentDescription = null,
                tint = UniqloTheme.colors.gray300,
                modifier = Modifier
                    .size(18.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ReviewStarPointPreview() {
    ReviewStarPoint(5)
}

@Composable
@Preview(showBackground = true)
private fun ReviewStarPointWithGrayPreview() {
    ReviewStarPoint(3)
}