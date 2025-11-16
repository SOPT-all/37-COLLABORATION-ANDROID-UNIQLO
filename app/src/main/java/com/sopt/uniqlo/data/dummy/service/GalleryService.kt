package com.sopt.uniqlo.data.dummy.service

import com.sopt.uniqlo.data.dummy.dto.GalleryImageResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GalleryService {
    @GET("v2/list")
    suspend fun getImages(
        @Query("page") page : Int,
        @Query("limit") limit : Int
    ) : Response<List<GalleryImageResponseDto>>
}