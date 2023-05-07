package com.romanhruska.plugins

import com.romanhruska.data.FellaController
import com.romanhruska.room.RoomController
import com.romanhruska.routes.chatSocket
import com.romanhruska.routes.getAllFellas
import com.romanhruska.routes.getAllMessages
import com.romanhruska.routes.insertFella
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val fellaController by inject<FellaController>()
    val roomController by inject<RoomController>() // thanks to this Koin will inject our RoomController
    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)

        insertFella(fellaController)
        getAllFellas(fellaController)
    }

}
