package com.sopt.uniqlo.presentation.detailpage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme

//TODO("버튼에 대한 상태값과 색 등을 전달받아 사용할지 고민 중
// -> 눌렀을 때 이벤트만 처리함 될거라 생각해서 여기에 했는데, ViewModel에서 해야할까?")
@Composable
fun ReviewHelpfulButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    helpfulCount: Int = 0,
) {
    var isClicked by remember { mutableStateOf(false) }
    var helpfulCount by remember { mutableIntStateOf(helpfulCount) }

    val backgroundColor = if (isClicked) UniqloTheme.colors.black else UniqloTheme.colors.white
    val borderColor = if (isClicked) UniqloTheme.colors.black else UniqloTheme.colors.gray200
    val textColor = if (isClicked) UniqloTheme.colors.white else UniqloTheme.colors.black

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(34.dp)
            .background(color = backgroundColor, shape = CircleShape)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = CircleShape
            )
            .clickable(
                enabled = !isClicked,
                onClick = {
                    onClick
                    helpfulCount += 1
                    isClicked = !isClicked
                }
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 8.dp)
        ) {
            Text(
                text = "도움돼요",
                color = textColor,
                style = UniqloTheme.typography.caption.r_12
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "$helpfulCount",
                color = textColor,
                style = UniqloTheme.typography.caption.r_12
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ReviewHelpfulButtonPreview() {
    ReviewHelpfulButton(
        onClick = {}
    )
}