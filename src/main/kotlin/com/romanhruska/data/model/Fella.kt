package com.romanhruska.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Fella (
    var fellaNick: String,
    var canCreateCrews: Boolean? = false,
    var referredBy: String? = null,
    @BsonId
    var fellaId: String = ObjectId().toString()
)