package com.sopt.uniqlo.presentation.detailpage.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.extension.noRippleClickable

@Composable
fun IconTextButton(
    @DrawableRes imgResource: Int,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imgDescription: String? = null,
    iconColor: Color = UniqloTheme.colors.black,
    textColor: Color = UniqloTheme.colors.black
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = UniqloTheme.colors.gray200,
                shape = CircleShape
            )
            .noRippleClickable(
                onClick = onClick
            )
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = imgResource),
            contentDescription = imgDescription,
            tint = iconColor,
        )
        Text(
            text = title,
            color = textColor,
            style = UniqloTheme.typography.caption.r_12,
            modifier = Modifier
                .padding(top = 2.dp, start = 4.dp, bottom = 2.dp, end = 5.dp)
        )
    }
}


@Composable
@Preview(showBackground = true)
private fun InquiryButtonPreview() {
    IconTextButton(
        imgResource = R.drawable.ic_inquiry,
        imgDescription = "문의하기 버튼",
        title = "문의하기",
        onClick = {}
    )
}