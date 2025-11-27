package com.sopt.uniqlo.presentation.detailpage

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.util.UiState
import com.sopt.uniqlo.domain.detailpage.usecase.GetProductDetailUseCase
import com.sopt.uniqlo.domain.detailpage.usecase.GetStyleHintListUseCase
import com.sopt.uniqlo.domain.productdetail.usecase.GetProductDetailHeaderUseCase
import com.sopt.uniqlo.domain.review.GetReviewListUseCase
import com.sopt.uniqlo.presentation.detailpage.model.DetailDescriptionModel
import com.sopt.uniqlo.presentation.detailpage.model.SizeInformationItemModel
import com.sopt.uniqlo.presentation.detailpage.model.StyleHintModel
import com.sopt.uniqlo.presentation.detailpage.model.toUiModel
import com.sopt.uniqlo.presentation.detailpage.navigation.DetailPage
import com.sopt.uniqlo.presentation.detailpage.state.DetailPageUiState
import com.sopt.uniqlo.presentation.detailpage.state.ProductDetailSideEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getProductDetailUseCase: GetProductDetailUseCase,
    private val getProductDetailHeaderUseCase: GetProductDetailHeaderUseCase,
    private val getStyleHintListUseCase: GetStyleHintListUseCase,
    private val getReviewListUseCase: GetReviewListUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetailPageUiState())
    val uiState: StateFlow<DetailPageUiState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<ProductDetailSideEffect>()
    val sideEffect: SharedFlow<ProductDetailSideEffect> = _sideEffect.asSharedFlow()

    private val productId: Int = savedStateHandle.toRoute<DetailPage>().id

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
        setStyleHintList()
        getReviewList(productId)
        loadProductDetail(productId)
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
            getProductDetailUseCase(productId = productId)
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


    fun setStyleHintList() {
        viewModelScope.launch {
            getStyleHintListUseCase(productId = productId)
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

    fun getReviewList(productId: Int) {
        viewModelScope.launch {
            getReviewListUseCase(productId.toLong())
                .onSuccess { result ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            reviewList = result.mapIndexed { index, entity ->
                                entity.toUiModel(id = index)
                            }
                        )
                    }
                }
                .onFailure(Timber::e)
        }
    }

    private fun loadProductDetail(productId: Int) {
        viewModelScope.launch {
            getProductDetailHeaderUseCase(productId)
                .onSuccess { productDetailEntity ->
                    val uiModel = productDetailEntity.toUiModel()
                    _uiState.update {
                        it.copy(
                            productDetailUiState = UiState.Success(uiModel),
                            selectedColorName = uiModel. colorName
                        )
                    }
                }
                .onFailure { throwable ->
                    val errorMessage = throwable.message ?: "상품 정보를 불러오지 못했습니다."
                    _uiState.update {
                        it.copy(
                            productDetailUiState = UiState.Failure(errorMessage),
                        )
                    }

                    _sideEffect.emit(
                        ProductDetailSideEffect.ShowToast("상품 정보를 불러오는데 실패했습니다: $errorMessage")
                    )
                }
        }
    }

    fun handleColorOptionClick(colorName: String) {
        _uiState.update {
            it.copy(
                selectedColorName = colorName,
            )
        }
    }
}