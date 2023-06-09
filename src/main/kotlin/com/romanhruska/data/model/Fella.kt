package com.romanhruska.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Fella (
    val id: String,
    val nick: String,
    val canCreateCrews: Boolean? = false,
    val referredBy: String? = null
)