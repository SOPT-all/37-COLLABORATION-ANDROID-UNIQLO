package com.sopt.uniqlo.presentation.detailpage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.core.extension.noRippleClickable

//TODO("하단 바의 이름 생각해보기 -> WishListBar라고 하면 장바구니 목록 들고올 듯한 기분")
//TODO("애들 크기가 46이 맞나? 그냥 max인데 높이만 46으로 넣은거 아닌가?")
@Composable
fun WishListBar(
    iconButtonClick: () -> Unit,
    wishListButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    barHeight: Int = 46
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(color = UniqloTheme.colors.white)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            CircleIconButton(
                icon = R.drawable.ic_heart,
                onClick = iconButtonClick,
                buttonSize = barHeight
            )
            Spacer(modifier = Modifier.width(15.dp))
            WishListButton(
                onClick = wishListButtonClick,
                modifier = Modifier.height(barHeight.dp)
            )
        }
    }
}

@Composable
fun WishListButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color = UniqloTheme.colors.black,
    textColor: Color = UniqloTheme.colors.white,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = buttonColor,
                shape = CircleShape
            )
            .noRippleClickable(
                onClick
            )
    ) {
        Text(
            text = "장바구니에 담기",
            color = textColor,
            style = UniqloTheme.typography.body.r_15,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun WishListBarPreview() {
    WishListBar(
        iconButtonClick = {},
        wishListButtonClick = {}
    )
}

@Composable
@Preview(showBackground = true)
private fun WishListButtonPreview() {
    WishListButton(
        onClick = {}
    )
}