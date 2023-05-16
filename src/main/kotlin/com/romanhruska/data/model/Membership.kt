package com.romanhruska.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Membership(
    val id: String,
    val fellaId: String,
    val crewId: String,
    val memberSince: String, //TODO Timestamp
    val canInviteOthers: Boolean
)
