package com.romanhruska.data.mysql

import com.romanhruska.data.FellaDataSource
import com.romanhruska.data.model.Fella
import com.romanhruska.data.model.Message
import org.ktorm.database.Database
import org.ktorm.database.asIterable
import org.ktorm.dsl.from
import org.ktorm.dsl.insert
import org.ktorm.dsl.select

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

    override suspend fun getAllFellas() : List<Fella> {
        val fellas = database.from(FellasTable).select()
        return fellas.rowSet.asIterable().map { row ->
            Fella(
                row[FellasTable.nick] ?: "",
                row[FellasTable.canCreateCrews] ?: false,
                row[FellasTable.referredBy] ?: "",
                row[FellasTable.id] ?: "",
            )
        }
    }
}