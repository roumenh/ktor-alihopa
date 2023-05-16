package com.romanhruska.data.sources

import com.romanhruska.alihopa.business.Crew
import com.romanhruska.data.model.Fella
import com.romanhruska.data.model.FellaDto

interface CrewDataSource {

    suspend fun joinCrew(crew: Crew, fella: Fella): Boolean

    /*suspend fun insertCrew(crew: Crew)

    suspend fun getAllCrews(): List<Crew>*/

}