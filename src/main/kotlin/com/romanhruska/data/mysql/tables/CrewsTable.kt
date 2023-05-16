package com.romanhruska.data.mysql.tables


import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.long
import org.ktorm.schema.varchar

object CrewsTable: Table<Nothing>("crews") {

    val id = varchar("id")
    val name = varchar("name")
    val description = varchar("description")

}