package com.romanhruska.data.repositories

import com.romanhruska.alihopa.business.Crew
import com.romanhruska.alihopa.business.CrewDto
import com.romanhruska.data.model.FellaDto
import com.romanhruska.data.model.MembershipDto
import com.romanhruska.data.sources.CrewDataSource

// Now contains also logic around memberships (maybe in future to move to separate repository ?)

class CrewRepository (
    private val crewDataSource: CrewDataSource
) {

    suspend fun insertMembership(membershipDto: MembershipDto) {
        // now we have received the data from request
        val membership = membershipDto.toMembership()
        // so far nothing magical is happening here, but we keep the mapper working

        crewDataSource.joinCrew(membership = membership)
    }


/*    suspend fun getAllCrews() : List<CrewDto>{
        var fellasDtoList = mutableListOf<FellaDto>()
        crewDataSource.get...().map {
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

    suspend fun checkFellaNick(nick: String) : Boolean = fellaDataSource.checkFellaNick(nick)*/
}