package com.romanhruska.data.repositories

import com.romanhruska.alihopa.business.Crew
import com.romanhruska.alihopa.business.CrewDto
import com.romanhruska.data.model.FellaDto
import com.romanhruska.data.sources.CrewDataSource

class CrewRepository (
    private val crewDataSource: CrewDataSource
) {

    suspend fun insertCrew(crewDto: CrewDto, fellaDto: FellaDto) {
        // now we have received the data from request

        val crew = crewDto.toCrew()
        val fella = fellaDto.toFella()
        // so far nothing magical is happening here, but we keep the mapper working

        crewDataSource.joinCrew(fella = fella, crew = crew)
    }


    suspend fun getAllCrews() : List<FellaDto>{
        var fellasDtoList = mutableListOf<FellaDto>()
        fellaDataSource.getAllFellas().map {
            fellasDtoList.add(
                FellaDto(
                    id = it.id,
                    nick = it.nick,
                    canCreateCrews = it.canCreateCrews
                )
            )
        }
        return fellasDtoList
    }

    suspend fun checkFellaNick(nick: String) : Boolean = fellaDataSource.checkFellaNick(nick)
}