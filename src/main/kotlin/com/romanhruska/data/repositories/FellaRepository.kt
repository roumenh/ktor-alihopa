package com.romanhruska.data.repositories

import com.romanhruska.data.model.FellaDto
import com.romanhruska.data.sources.FellaDataSource

class FellaRepository (
    private val fellaDataSource: FellaDataSource
) {

    suspend fun insertFella(fellaDto: FellaDto) {
        // now we have received the data from request

        val fella = fellaDto.toFella()
        // so far nothing magical is happening here, but we keep the mapper working

        fellaDataSource.insertFella(fella)
    }


    suspend fun getAllFellas() : List<FellaDto>{
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