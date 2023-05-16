package com.romanhruska.data.mysql

import com.romanhruska.alihopa.business.Crew
import com.romanhruska.data.sources.CrewDataSource
import com.romanhruska.data.model.Fella
import com.romanhruska.data.mysql.tables.FellasTable
import org.ktorm.dsl.insert

class CrewDataSourceImpl : CrewDataSource {
    override suspend fun joinCrew(crew: Crew, fella: Fella): Boolean {
        database.insert() {
            set(it.id, fella.id)
            set(it.nick, fella.nick)
            set(it.canCreateCrews, fella.canCreateCrews)
            set(it.referredBy, fella.referredBy)
        }
    }
}