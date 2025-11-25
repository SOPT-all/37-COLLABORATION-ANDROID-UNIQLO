package com.sopt.uniqlo.presentation.detailpage.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme

@Composable
fun TextWithLeadingIcon(
    text: String,
    modifier: Modifier = Modifier,
    leadingIconColor: Color = UniqloTheme.colors.black,
    textColor: Color = UniqloTheme.colors.black,
) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(),
    ) {
        Text(
            text = "•",
            color = leadingIconColor,
            style = UniqloTheme.typography.body.r_13,
            modifier = Modifier
                .padding(horizontal = 4.dp),
        )
        Text(
            text = text,
            color = textColor,
            style = UniqloTheme.typography.body.r_13,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun TextWithLeadingIconPreview() {
    TextWithLeadingIcon(
        text = "test"
    )
}