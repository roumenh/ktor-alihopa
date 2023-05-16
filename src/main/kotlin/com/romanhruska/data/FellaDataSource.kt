package com.romanhruska.data

import com.romanhruska.data.model.Fella
import com.romanhruska.data.model.FellaDto

interface FellaDataSource {

    suspend fun insertFella(fella: Fella)

    suspend fun getAllFellas(): List<Fella>

    suspend fun checkFellaNick(nick: String): Boolean

}