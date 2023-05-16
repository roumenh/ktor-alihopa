package com.romanhruska.di

import com.romanhruska.data.mysql.CrewDataSourceImpl
import com.romanhruska.data.repositories.FellaRepository
import com.romanhruska.data.sources.FellaDataSource
import com.romanhruska.data.sources.MessageDataSource
import com.romanhruska.data.mysql.FellaDataSourceImpl
import com.romanhruska.data.mysql.MysqlMessageDataSourceImpl
import com.romanhruska.data.repositories.CrewRepository
import com.romanhruska.data.sources.CrewDataSource
import com.romanhruska.room.RoomController
import org.koin.dsl.module
import org.ktorm.database.Database
import java.util.*

val mainModule = module {

    single<Database> {
        val props = Properties()
        props.load(javaClass.classLoader.getResourceAsStream("keys.properties"))
        Database.connect(
            url = props.getProperty("db.url"),
            driver = props.getProperty("db.driver"),
            user = props.getProperty("db.user"),
            password = props.getProperty("db.password")
        )
    }
    // should return Database

    single<FellaDataSource> {
        FellaDataSourceImpl(get())
    }
    single<CrewDataSource> {
        CrewDataSourceImpl(get())
    }

    single<MessageDataSource> {
        MysqlMessageDataSourceImpl(get())
    }

    single {
        FellaRepository(get())
    }

    single {
        CrewRepository(get())
    }

    single {
        RoomController(get())
    }

}