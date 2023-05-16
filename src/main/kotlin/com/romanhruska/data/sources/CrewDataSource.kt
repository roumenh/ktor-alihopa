package com.romanhruska.data.sources

import com.romanhruska.alihopa.business.Crew
import com.romanhruska.data.model.Fella
import com.romanhruska.data.model.FellaDto
import com.romanhruska.data.model.Membership

interface CrewDataSource {

    suspend fun joinCrew(membership: Membership): Boolean

    /*suspend fun insertCrew(crew: Crew)

    suspend fun getAllCrews(): List<Crew>*/

}