package com.romanhruska.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Fella (
    var id: String,
    var nick: String,
    var canCreateCrews: Boolean? = false,
    var referredBy: String? = null
)