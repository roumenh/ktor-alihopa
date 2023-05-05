package com.romanhruska.data

import com.romanhruska.data.model.Fella

class FellaController (
    //private val messageDataSource: MessageDataSource,
    private val fellaDataSource: FellaDataSource
) {

    suspend fun insertFella(nick: String) {
        val fellaEntity = Fella(  // moved out of the foreach lambda
            fellaNick = nick
        )
        fellaDataSource.insertFella(fellaEntity)
    }
}