package com.sopt.uniqlo.domain.detailpage.repository

import com.sopt.uniqlo.R
import com.sopt.uniqlo.domain.detailpage.entity.SizeInformationEntity

interface SizeInformationRepository {
    suspend fun getSizeInformationDummyListUseCase(): List<SizeInformationEntity>{
        return listOf(
            SizeInformationEntity(
                imgResource = R.drawable.img_detail_page_size_chart,
                title = "사이즈 차트",
                description = "제품을 구매하기 전, 이전에 구매했던 제품의 사이즈와 비교해 보세요.",
            ),
            SizeInformationEntity(
                imgResource = R.drawable.img_detail_page_stature_guide,
                title = "신장별 착용 가이드",
                description = "신장에 따른 제품의 전체 길이를 확인해 보세요."
            ),
            SizeInformationEntity(
                imgResource = R.drawable.img_detail_page_size_assist,
                title = "마이 사이즈 어시스트",
                description = "치수를 간단히 입력하거나 카메라 캡처를 통해 권장 사이즈를 확인해 보세요."
            ),
            SizeInformationEntity(
                imgResource = R.drawable.img_detail_page_styling,
                title = "신장별 스타일링",
                description = "나와 비슷한 체형의 고객이 착용한 사이즈를 확인해 보세요."
            )
        )
    }
}