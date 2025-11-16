package com.sopt.uniqlo.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Todo : 추루 서버 구조에 따라 변경 예정
@Serializable
data class BaseResponse<T>(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T? = null
)
