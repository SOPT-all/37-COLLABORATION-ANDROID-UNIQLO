package com.sopt.uniqlo.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object PretendardFont {
    val semiBold = FontFamily(Font(0, FontWeight.SemiBold))
    val medium = FontFamily(Font(0, FontWeight.Medium))
    val regular = FontFamily(Font(0, FontWeight.Normal))
    val light = FontFamily(Font(0, FontWeight.Light))
}

object RedditSansFont {
    val semiBold = FontFamily(Font(0, FontWeight.SemiBold))
    val medium = FontFamily(Font(0, FontWeight.Medium))
    val regular = FontFamily(Font(0, FontWeight.Normal))
}

sealed interface TypographyTokens {

    @Immutable
    data class Title(
        // Pretendard Title
        val sb_26: TextStyle, // title_sb_26
        val m_24: TextStyle,  // title_m_24
        val r_20: TextStyle,  // title_r_20
        val m_18: TextStyle,  // title_m_18
        val m_16: TextStyle,  // title_m_16
        val l_16: TextStyle,  // title_l_16
    )

    @Immutable
    data class Body(
        // Pretendard Body
        val sb_15: TextStyle, // body_sb_15
        val r_15: TextStyle,  // body_r_15
        val sb_13: TextStyle, // body_sb_13
        val r_13: TextStyle,  // body_r_13
    )

    @Immutable
    data class Caption(
        // Pretendard Caption
        val m_12: TextStyle,  // caption_m_12
        val r_12: TextStyle,  // caption_r_12
        val l_12: TextStyle,  // caption_l_12
        val sb_11: TextStyle, // caption_sb_11
        val l_11: TextStyle,  // caption_l_11
        val l_10: TextStyle,  // caption_l_10
        val r_9: TextStyle,   // caption_r_9
    )

    @Immutable
    data class Reddit(
        // Reddit Sans Condensed
        val body_r_14: TextStyle,
        val caption_m_13: TextStyle,
        val caption_sb_12: TextStyle,
        val caption_m_12: TextStyle,
    )
}

@Immutable
data class UniqloTypography(
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body,
    val caption: TypographyTokens.Caption,
    val reddit: TypographyTokens.Reddit,
)

val uniqloDefaultTypography = UniqloTypography(
    title = TypographyTokens.Title(
        sb_26 = TextStyle(
            fontFamily = PretendardFont.semiBold,
            fontSize = 26.sp,
            lineHeight = (26 * 1.5f).sp
        ),
        m_24 = TextStyle(
            fontFamily = PretendardFont.medium,
            fontSize = 24.sp,
            lineHeight = (24 * 1.5f).sp
        ),
        r_20 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 20.sp,
            lineHeight = (20 * 1.5f).sp
        ),
        m_18 = TextStyle(
            fontFamily = PretendardFont.medium,
            fontSize = 18.sp,
            lineHeight = (18 * 1.5f).sp
        ),
        m_16 = TextStyle(
            fontFamily = PretendardFont.medium,
            fontSize = 16.sp,
            lineHeight = (16 * 1.5f).sp
        ),
        l_16 = TextStyle(
            fontFamily = PretendardFont.light,
            fontSize = 16.sp,
            lineHeight = (16 * 1.5f).sp
        ),
    ),
    body = TypographyTokens.Body(
        sb_15 = TextStyle(
            fontFamily = PretendardFont.semiBold,
            fontSize = 15.sp,
            lineHeight = (15 * 1.5f).sp
        ),
        r_15 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 15.sp,
            lineHeight = (15 * 1.5f).sp
        ),
        sb_13 = TextStyle(
            fontFamily = PretendardFont.semiBold,
            fontSize = 13.sp,
            lineHeight = (13 * 1.5f).sp
        ),
        r_13 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 13.sp,
            lineHeight = (13 * 1.5f).sp
        ),
    ),
    caption = TypographyTokens.Caption(
        m_12 = TextStyle(
            fontFamily = PretendardFont.medium,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
        r_12 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
        l_12 = TextStyle(
            fontFamily = PretendardFont.light,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
        sb_11 = TextStyle(
            fontFamily = PretendardFont.semiBold,
            fontSize = 11.sp,
            lineHeight = (11 * 1.5f).sp
        ),
        l_11 = TextStyle(
            fontFamily = PretendardFont.light,
            fontSize = 11.sp,
            lineHeight = (11 * 1.5f).sp
        ),
        l_10 = TextStyle(
            fontFamily = PretendardFont.light,
            fontSize = 10.sp,
            lineHeight = (10 * 1.5f).sp
        ),
        r_9 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 9.sp,
            lineHeight = (9 * 1.6f).sp
        ),
    ),
    reddit = TypographyTokens.Reddit(
        body_r_14 = TextStyle(
            fontFamily = RedditSansFont.regular,
            fontSize = 14.sp,
            lineHeight = (14 * 1.5f).sp
        ),
        caption_m_13 = TextStyle(
            fontFamily = RedditSansFont.medium,
            fontSize = 13.sp,
            lineHeight = (13 * 1.5f).sp
        ),
        caption_sb_12 = TextStyle(
            fontFamily = RedditSansFont.semiBold,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
        caption_m_12 = TextStyle(
            fontFamily = RedditSansFont.medium,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
    )
)

val localUniqloTypography = staticCompositionLocalOf { uniqloDefaultTypography }