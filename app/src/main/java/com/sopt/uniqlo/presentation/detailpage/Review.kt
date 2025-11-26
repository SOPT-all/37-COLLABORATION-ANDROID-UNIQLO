package com.sopt.uniqlo.presentation.detailpage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.designsystem.theme.UniqloTheme
import com.sopt.uniqlo.presentation.detailpage.component.IconTextButton
import com.sopt.uniqlo.presentation.detailpage.component.ReadMoreButton
import com.sopt.uniqlo.presentation.detailpage.model.ReviewModel
import kotlin.math.roundToInt

@Composable
fun Review(
    reviewList: List<ReviewModel>,
    reviewStarPointAverage: Float,
    reviewFitAverage: Int,
    onHelpfulClick: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "리뷰",
                color = UniqloTheme.colors.black,
                style = UniqloTheme.typography.title.r_20
            )
            IconTextButton(
                imgResource = R.drawable.ic_review,
                title = "리뷰 작성",
                onClick = {}
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            ReviewStarPoint(
                starPoint = reviewStarPointAverage.roundToInt(),
                iconSize = 22
            )
            Text(
                text = "$reviewStarPointAverage",
                color = UniqloTheme.colors.black,
                style = UniqloTheme.typography.body.sb_15,
            )
            Text(
                text = "(${reviewList.size})",
                color = UniqloTheme.colors.blueMain,
                style = UniqloTheme.typography.body.sb_13,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        ReviewFitAverage(fitAverage = reviewFitAverage)
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            reviewList.forEach { review ->
                HorizontalDivider(thickness = 1.dp, color = UniqloTheme.colors.gray200)
                ReviewItem(
                    review = review,
                    onHelpfulClick = {
                        onHelpfulClick(review.title, review.isHelpful)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        ReadMoreButton(
            text = "리뷰",
            onClick = {}
        )
    }
}

@Composable
private fun ReviewItem(
    review: ReviewModel,
    onHelpfulClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = review.title,
                color = UniqloTheme.colors.black,
                style = UniqloTheme.typography.body.r_15,
            )
            Text(
                text = review.createdAt,
                color = UniqloTheme.colors.gray300,
                style = UniqloTheme.typography.caption.r_12,
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        ReviewStarPoint(review.star.roundToInt())
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "구매 사이즈: ${review.size}",
                color = UniqloTheme.colors.gray600,
                style = UniqloTheme.typography.caption.m_12,
            )
            Text(
                text = "구매 색상: ${review.color}",
                color = UniqloTheme.colors.gray600,
                style = UniqloTheme.typography.caption.m_12,
            )
            Text(
                text = "착용감: ${review.fit}",
                color = UniqloTheme.colors.gray600,
                style = UniqloTheme.typography.caption.m_12,
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
        Text(
            text = review.content,
            color = UniqloTheme.colors.gray900,
            style = UniqloTheme.typography.body.r_13,
        )
        Spacer(modifier = Modifier.height(19.dp))
        Text(
            text = if (review.gender == "선택하지 않음" || review.height == "선택하지 않음") {
                "선택하지않음"
            } else {
                "${review.gender} · ${review.height}"
            },
            color = UniqloTheme.colors.gray300,
            style = UniqloTheme.typography.caption.r_12,
        )
        Spacer(modifier = Modifier.height(21.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            IconTextButton(
                imgResource = R.drawable.ic_report,
                title = "신고하기",
                onClick = {}
            )
            ReviewHelpfulButton(
                isHelpful = review.isHelpful,
                helpfulCount = review.recommend,
                onClick = onHelpfulClick,
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
    }
}

@Composable
private fun ReviewFitAverage(
    fitAverage: Int,
    modifier: Modifier = Modifier
) {
    val fitText: List<String> = listOf("작다", "딱맞다", "크다")

    Column(modifier = modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = UniqloTheme.colors.gray200,
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .fillMaxWidth()
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(5) { index ->
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (index != fitAverage - 1) {
                                    UniqloTheme.colors.gray200
                                } else {
                                    UniqloTheme.colors.black
                                },
                                shape = CircleShape
                            )
                            .size(
                                if (index != fitAverage - 1) {
                                    6.dp
                                } else {
                                    10.dp
                                }
                            )
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            fitText.forEach { text ->
                Text(
                    text = text,
                    color = UniqloTheme.colors.black,
                    style = UniqloTheme.typography.caption.l_11,
                )
            }
        }
    }
}

@Composable
private fun ReviewHelpfulButton(
    isHelpful: Boolean,
    helpfulCount: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = if (isHelpful) UniqloTheme.colors.black else UniqloTheme.colors.white
    val borderColor = if (isHelpful) UniqloTheme.colors.black else UniqloTheme.colors.gray200
    val textColor = if (isHelpful) UniqloTheme.colors.white else UniqloTheme.colors.black

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
                enabled = !isHelpful,
                onClick = onClick
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
fun ReviewStarPoint(
    starPoint: Int,
    modifier: Modifier = Modifier,
    iconSize: Int = 18,
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
                    .size(iconSize.dp)
            )
        }
        repeat(5 - starPoint) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_gray),
                contentDescription = null,
                tint = UniqloTheme.colors.gray300,
                modifier = Modifier
                    .size(iconSize.dp)
            )
        }
    }
}

//프리뷰
@Composable
@Preview(showBackground = true)
private fun ReviewPreview() {
    Review(
        reviewList = listOf(
            ReviewModel(
                title = "가을 가을합니다",
                content = "가을에 매장에서 입어보고 마음에 들어 온라인으로 xs사이즈 구매했는데 적당한 길이감에 단정하게 이쁩니다",
                star = 5f,
                createdAt = "2023/01/01",
                height = "170cm",
                gender = "남성",
                recommend = 10,
                size = "M",
                color = "빨강",
                fit = "정장",
            ), ReviewModel(
                title = "가을 가을합니다",
                content = "가을에 매장에서 입어보고 마음에 들어 온라인으로 xs사이즈 구매했는데 적당한 길이감에 단정하게 이쁩니다",
                star = 5f,
                createdAt = "2023/01/01",
                height = "선택하지 않음",
                gender = "선택하지 않음",
                recommend = 10,
                size = "M",
                color = "빨강",
                fit = "정장",
            )
        ),
        reviewStarPointAverage = 4.8f,
        reviewFitAverage = 5,
        onHelpfulClick = {title, isSelected ->}
    )
}

@Composable
@Preview(showBackground = true)
private fun ReviewItemPreview() {
    ReviewItem(
        review = ReviewModel(
            title = "가을 가을합니다",
            content = "가을에 매장에서 입어보고 마음에 들어 온라인으로 xs사이즈 구매했는데 적당한 길이감에 단정하게 이쁩니다",
            star = 5f,
            createdAt = "2023/01/01",
            height = "170cm",
            gender = "남성",
            recommend = 10,
            size = "M",
            color = "빨강",
            fit = "정장",
            isHelpful = true
        ),
        onHelpfulClick = {}
    )
}

@Composable
@Preview(showBackground = true)
private fun ReviewFitAveragePreview() {
    ReviewFitAverage(fitAverage = 2)
}

@Composable
@Preview(showBackground = true)
private fun ReviewHelpfulButtonPreview() {
    ReviewHelpfulButton(
        isHelpful = false,
        helpfulCount = 10,
        onClick = {}
    )
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