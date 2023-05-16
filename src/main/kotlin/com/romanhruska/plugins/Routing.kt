package com.romanhruska.plugins

import com.romanhruska.data.repositories.CrewRepository
import com.romanhruska.data.repositories.FellaRepository
import com.romanhruska.room.RoomController
import com.romanhruska.routes.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val fellaRepository by inject<FellaRepository>()
    val crewRepository by inject<CrewRepository>()
    val roomController by inject<RoomController>() // thanks to this Koin will inject our RoomController
    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)

        insertFella(fellaRepository)
        getAllFellas(fellaRepository)
        checkFellaNick(fellaRepository)
        insertMembership(crewRepository)
    }

}
