package com.romanhruska.data.mysql.tables

import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.long
import org.ktorm.schema.varchar

object MembershipTable: Table<Nothing>("memberships") {

    val id = varchar("id")
    val fellaId = varchar("fellaId")
    val crewId = varchar("crewId")
    val memberSince = long("memberSince")
    val canInviteOthers = boolean("canInviteOthers")

}