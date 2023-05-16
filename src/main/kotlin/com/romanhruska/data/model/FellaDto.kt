package com.romanhruska.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class FellaDto (
    var id: String,
    var nick: String,
    var canCreateCrews: Boolean? = false,
    var referredBy: String? = null
)

fun FellaDto.toFella() = Fella(
    nick = this.nick,
    id = this.id,
    canCreateCrews = this.canCreateCrews,
)