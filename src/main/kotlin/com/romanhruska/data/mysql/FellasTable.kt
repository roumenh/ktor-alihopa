package com.romanhruska.data.mysql


import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.long
import org.ktorm.schema.varchar

object FellasTable: Table<Nothing>("fellas") {

    val id = varchar("id")
    val nick = varchar("nick")
    val referredBy = varchar("referredBy")
    val canCreateCrews = boolean("canCreateCrews")

}