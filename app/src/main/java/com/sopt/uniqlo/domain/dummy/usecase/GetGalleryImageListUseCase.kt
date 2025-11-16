package com.sopt.uniqlo.domain.dummy.usecase

import com.sopt.uniqlo.domain.dummy.repository.GalleryRepository
import javax.inject.Inject

class GetGalleryImageListUseCase @Inject constructor(
    private val repository: GalleryRepository
) {
    suspend operator fun invoke(page : Int, limit : Int) = repository.getGalleryImageList(page, limit)
}