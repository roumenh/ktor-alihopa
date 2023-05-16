package com.romanhruska.routes

import com.romanhruska.data.FellaRepository
import com.romanhruska.data.model.FellaDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.insertFella(fellaRepository: FellaRepository) {
    post("/fella") {
        try {
            val postFellaDto = call.receive<FellaDto>()
            fellaRepository.insertFella(postFellaDto)  // TODO remake,, this does not make much sense, or has it?
            call.respondText ("Hello, this is $postFellaDto from the post body", ContentType.Text.Plain)


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

fun Route.getAllFellas(fellaRepository: FellaRepository) {
    get("/fellas") {
        call.respond(
            HttpStatusCode.OK,
            fellaRepository.getAllFellas()
        )
    }
}


fun Route.checkFellaNick(fellaRepository: FellaRepository) {
    get("/check-fella-nick/{nick}") {
        val nick = call.parameters["nick"]
        if (nick != null){
            call.respond(
                HttpStatusCode.OK,
                fellaRepository.checkFellaNick(nick)
            )
        }
       // TODO else + error handling
    }
}
