package com.romanhruska.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class FellaDto (
    val id: String,
    val nick: String,
    val canCreateCrews: Boolean? = false,
    val referredBy: String? = null
) {
    fun toFella() = Fella(
        nick = this.nick,
        id = this.id,
        canCreateCrews = this.canCreateCrews,
    )
}