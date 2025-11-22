package com.sopt.uniqlo.presentation.detailpage.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.extension.noRippleClickable

@Composable
fun ReadMoreButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = UniqloTheme.colors.black
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .noRippleClickable(
                onClick = onClick
            )
            .border(
                width = 1.dp,
                color = UniqloTheme.colors.gray200,
            )
            .fillMaxWidth()
            .height(37.dp)
    ) {
        Text(
            text = "$text 더 보기",
            color = textColor,
            style = UniqloTheme.typography.body.r_13,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun ReadMoreButtonPreview() {
    ReadMoreButton(
        text = "스타일링",
        onClick = {}
    )
}