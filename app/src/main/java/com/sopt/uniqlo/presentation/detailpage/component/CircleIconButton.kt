package com.sopt.uniqlo.presentation.detailpage.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
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
import timber.log.Timber

@Composable
fun CircleIconButton(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    buttonSize: Int = 40,
    buttonColor: Color = UniqloTheme.colors.white,
    iconSize: Int = 22,
    iconColor: Color = UniqloTheme.colors.black
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .noRippleClickable(
                onClick = onClick
            )
            .size(buttonSize.dp)
            .border(
                width = 1.dp,
                color = UniqloTheme.colors.gray200,
                shape = CircleShape
            )
            .background(color = buttonColor, shape = CircleShape)
    ){
        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = contentDescription,
            tint = iconColor,
            modifier = Modifier
                .size(iconSize.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun IconButtonPreview() {
    CircleIconButton(
        icon = R.drawable.ic_heart,
        buttonSize = 40,
        onClick = {}
    )
}