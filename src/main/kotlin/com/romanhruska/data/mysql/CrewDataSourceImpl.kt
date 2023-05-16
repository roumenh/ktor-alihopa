package com.romanhruska.data.mysql

import com.romanhruska.alihopa.business.Crew
import com.romanhruska.data.sources.CrewDataSource
import com.romanhruska.data.model.Fella
import com.romanhruska.data.model.Membership
import com.romanhruska.data.mysql.tables.FellasTable
import com.romanhruska.data.mysql.tables.MembershipTable
import org.ktorm.database.Database
import org.ktorm.dsl.insert

class CrewDataSourceImpl(
    private val database: Database
) : CrewDataSource {
    override suspend fun joinCrew(membership: Membership): Boolean {
        database.insert(MembershipTable) {
            set(it.id, membership.id)
            set(it.fellaId, membership.fellaId)
            set(it.crewId, membership.crewId)
            set(it.memberSince, membership.memberSince)
            set(it.canInviteOthers, membership.canInviteOthers)
        }
        return true
    }
}