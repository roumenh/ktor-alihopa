package com.romanhruska.data.mysql

import com.romanhruska.data.sources.FellaDataSource
import com.romanhruska.data.model.Fella
import com.romanhruska.data.mysql.tables.FellasTable
import org.ktorm.database.Database
import org.ktorm.database.asIterable
import org.ktorm.dsl.*

class FellaDataSourceImpl(
    private val database: Database
) : FellaDataSource {
    override suspend fun insertFella(fella: Fella) {
        database.insert(FellasTable) {
            set(it.id, fella.id)
            set(it.nick, fella.nick)
            set(it.canCreateCrews, fella.canCreateCrews)
            set(it.referredBy, fella.referredBy)
        }
    }

    override suspend fun getAllFellas() : List<Fella> {
        val query = database.from(FellasTable).select()
        return query.rowSet.asIterable().map { row ->
            Fella(
                row[FellasTable.id] ?: "",
                row[FellasTable.nick] ?: "",
                row[FellasTable.canCreateCrews] ?: false,
                row[FellasTable.referredBy] ?: "",
            )
        }
    }

    override suspend fun checkFellaNick(nick: String): Boolean {
        val query  = database.from(FellasTable).select().where { (FellasTable.nick eq nick) }
        return (query.rowSet.size() > 0)
    }
}