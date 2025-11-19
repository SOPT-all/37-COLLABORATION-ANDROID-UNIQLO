package com.sopt.uniqlo.domain.detailpage.usecase

import com.sopt.uniqlo.domain.detailpage.repository.SizeInformationRepository
import javax.inject.Inject

class GetSizeInformationDummyListUseCase @Inject constructor(
    private val repository: SizeInformationRepository
) {
    suspend operator fun invoke() = repository.getSizeInformationDummyListUseCase()
}