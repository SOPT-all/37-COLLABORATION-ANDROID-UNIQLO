package com.sopt.uniqlo.presentation.detailpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.uniqlo.R
import com.sopt.uniqlo.domain.detailpage.usecase.GetProductDetailUseCase
import com.sopt.uniqlo.domain.detailpage.usecase.GetStyleHintListUseCase
import com.sopt.uniqlo.presentation.detailpage.model.DetailDescriptionModel
import com.sopt.uniqlo.presentation.detailpage.model.ReviewModel
import com.sopt.uniqlo.presentation.detailpage.model.SizeInformationItemModel
import com.sopt.uniqlo.presentation.detailpage.model.StyleHintModel
import com.sopt.uniqlo.presentation.detailpage.model.toUiModel
import com.sopt.uniqlo.presentation.detailpage.state.DetailPageUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase,
    private val getStyleHintListUseCase: GetStyleHintListUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetailPageUiState())
    val uiState: StateFlow<DetailPageUiState> = _uiState.asStateFlow()

    val id = 1

    val detailDescriptionDummyData = DetailDescriptionModel(
        detailPageUrl = emptyList(),
        detailText = "적당한 탄탄함이 느껴지는 원단을 사용하였습니다.",
        descriptionText = listOf(
            "가디건처럼 걸쳐 입기 좋습니다.",
            "쇼트 기장으로 클린한 룩은 물론 캐주얼한 룩으로도 연출할 수 있습니다."
        ),
        featureDetailText = listOf(
            "비침: 없음",
            "핏: 보통 핏(레귤러)",
            "포켓(주머니): 있음"
        ),
        sizeDetailText = listOf(
            "게재된 이미지에는 판매 예정이 없는 컬러가 포함되어 있을 수 있습니다.",
            "취급 점포에 따라 상품의 품절 및 판매일 변경 될 수 있습니다.",
            "모니터사양에 따라 상품의 색상 및 무늬 등이 실제 상품과 다소 차이 날 수 있습니다.",
            "XS, XXL, 3XL 사이즈는 온라인 스토어에서만 판매합니다."
        )
    )

    val sizeInformationDummyList = listOf(
        SizeInformationItemModel(
            imgResource = R.drawable.img_detail_page_size_chart,
            title = "사이즈 차트",
            description = "제품을 구매하기 전, 이전에 구매했던 제품의 사이즈와 비교해 보세요.",
        ),
        SizeInformationItemModel(
            imgResource = R.drawable.img_detail_page_stature_guide,
            title = "신장별 착용 가이드",
            description = "신장에 따른 제품의 전체 길이를 확인해 보세요."
        ),
        SizeInformationItemModel(
            imgResource = R.drawable.img_detail_page_size_assist,
            title = "마이 사이즈 어시스트",
            description = "치수를 간단히 입력하거나 카메라 캡처를 통해 권장 사이즈를 확인해 보세요."
        ),
        SizeInformationItemModel(
            imgResource = R.drawable.img_detail_page_styling,
            title = "신장별 스타일링",
            description = "나와 비슷한 체형의 고객이 착용한 사이즈를 확인해 보세요."
        )
    )

    val reviewDummyList = listOf(
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
            title = "가을 가을합니다!",
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
    )

    val styleHintDummyList = listOf(
        StyleHintModel(
            imgUrl = "",
            isLiked = false,
        ),
        StyleHintModel(
            imgUrl = "",
            isLiked = true,
        ), StyleHintModel(
            imgUrl = "",
            isLiked = true,
        )
    )


    init {
        setDetailDescriptionData()
        setSizeInformationList()
        setReviewList()
        setStyleHintList()
    }

    fun setStyleHintLiked(id: Int) {
        val currentStyleHintList = _uiState.value.styleHintList
        val updatedStyleHintList = currentStyleHintList.map { styleHint ->
            if (styleHint.id == id) {
                styleHint.copy(
                    isLiked = !styleHint.isLiked
                )
            } else {
                styleHint
            }
        }
        _uiState.update {
            it.copy(
                styleHintList = updatedStyleHintList
            )
        }
    }

    fun setReviewHelpful(id: Int, isHelpful: Boolean) {
        val currentReviewList = _uiState.value.reviewList
        val updatedReviewList = currentReviewList.map { review ->
            if (review.id == id) {
                review.copy(
                    isHelpful = !isHelpful,
                    recommend = review.recommend + 1
                )
            } else {
                review
            }
        }
        _uiState.update {
            it.copy(
                reviewList = updatedReviewList
            )
        }
    }

    fun setTabState(tabState: TabState) {
        _uiState.update {
            it.copy(
                tabState = tabState
            )
        }
    }

    fun setIsWished() {
        _uiState.update {
            it.copy(
                isWished = !_uiState.value.isWished
            )
        }
    }

    fun setDetailDescriptionData() {
        viewModelScope.launch {
            getProductDetailUseCase(productId = id)
                .onSuccess { data ->
                    _uiState.update { state ->
                        state.copy(
                            detailDescription = data.toUiModel()
                        )
                    }
                }
                .onFailure { failure ->
                    Timber.e( "$failure")
                    _uiState.update {
                        it.copy(
                            detailDescription = detailDescriptionDummyData
                        )
                    }
                }
        }
    }

    fun setSizeInformationList() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    sizeInformationList = sizeInformationDummyList
                )
            }
        }
    }

    fun setReviewList() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    reviewList = reviewDummyList
                )
            }
        }
    }

    fun setStyleHintList() {
        viewModelScope.launch {
            getStyleHintListUseCase(productId = id)
                .onSuccess { data ->
                    _uiState.update { state ->
                        state.copy(
                            styleHintList = data.toUiModel()
                        )
                    }
                }
                .onFailure { failure ->
                    Timber.e("$failure")
                    _uiState.update {
                        it.copy(
                            styleHintList = styleHintDummyList.mapIndexed { index, entity ->
                                entity.copy(
                                    id = index + 1
                                )
                            }
                        )
                    }
                }
        }
    }
}