package com.romanhruska.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class MembershipDto(
    val id: String,
    val fellaId: String,
    val crewId: String,
    val memberSince: Long, //TODO Timestamp
    val canInviteOthers: Boolean
){
    fun toMembership(): Membership =
        Membership(
            id = id,
            fellaId = fellaId,
            crewId = crewId,
            memberSince = System.currentTimeMillis(),  //TODO
            canInviteOthers = canInviteOthers
        )

}
