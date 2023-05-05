package com.romanhruska.data

import com.romanhruska.data.model.Fella

interface FellaDataSource {

    suspend fun insertFella(fella: Fella)

}