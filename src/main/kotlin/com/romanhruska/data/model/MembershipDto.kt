package com.romanhruska.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class MembershipDto(
    @BsonId
    var id: String = ObjectId().toString()
)
