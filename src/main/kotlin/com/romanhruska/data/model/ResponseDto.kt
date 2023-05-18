package com.romanhruska.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto(
    val success: Boolean,
    val message: String,
)
