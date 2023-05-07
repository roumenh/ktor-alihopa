package com.romanhruska.routes

import com.romanhruska.data.FellaController
import com.romanhruska.data.model.Fella
import com.romanhruska.room.RoomController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.insertFella(fellaController: FellaController) {
    post("/fella") {
        try {
            val post = call.receive<Fella>()
            fellaController.insertFella(post.fellaNick)  // TODO remake,, this does not make much sense
            call.respondText ("Hello, this is $post from the post body", ContentType.Text.Plain)


        } catch (e: io.ktor.serialization.JsonConvertException){
            call.respondText ("The structure expected does not match!", ContentType.Text.Plain)} catch (e: io.ktor.serialization.JsonConvertException){
        } catch (e: io.ktor.server.plugins.BadRequestException){
            call.respondText ("Failed to convert request body to class !", ContentType.Text.Plain)
            // TODO maybe no need for the specific exception non-handling
        } catch (e: Exception) {
            call.respondText ("Something went wrong ${e.printStackTrace()}")
        }
    }
}

fun Route.getAllFellas(fellaController: FellaController) {
    get("/fellas") {
        call.respond(
            HttpStatusCode.OK,
            fellaController.getAllFellas()
        )
    }
}
