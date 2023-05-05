package com.romanhruska.data.mysql

import com.romanhruska.data.FellaDataSource
import com.romanhruska.data.model.Fella
import org.ktorm.database.Database
import org.ktorm.dsl.insert

class FellaDataSourceImpl(
    private val database: Database
) : FellaDataSource {
    override suspend fun insertFella(fella: Fella) {
        database.insert(FellasTable) {
            set(it.canCreateCrews, fella.canCreateCrews)
            set(it.referredBy, fella.referredBy)
            set(it.nick, fella.fellaNick)
            set(it.id, fella.fellaId)
        }
    }
}