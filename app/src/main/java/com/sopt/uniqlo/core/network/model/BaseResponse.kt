package com.sopt.uniqlo.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("code")
    val code: Long,
    @SerialName("msg")
    val msg: String,
    @SerialName("data")
    val data: T? = null
)