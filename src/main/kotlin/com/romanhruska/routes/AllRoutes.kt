package com.romanhruska.routes

import com.romanhruska.data.repositories.FellaRepository
import com.romanhruska.data.model.FellaDto
import com.romanhruska.data.model.MembershipDto
import com.romanhruska.data.model.ResponseDto
import com.romanhruska.data.repositories.CrewRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.insertFella(fellaRepository: FellaRepository) {
    post("/fella") {
        try {
            // id of fella comes together with the request, so it is generated on app side.
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


// ---------------- Memberships ------------------------
fun Route.insertMembership(crewRepository: CrewRepository) {
    post("/membership") {
        try {
            // id of fella comes together with the request, so it is generated on app side.
            val postMembershipDto = call.receive<MembershipDto>()
            crewRepository.insertMembership(postMembershipDto)  // TODO remake,, this does not make much sense, or has it?
            val response = ResponseDto(
                success = true,
                message = "Membership created"
            )
            call.response.status(HttpStatusCode.OK)
            call.respond(response)

        } catch (e: Exception) {
            call.response.status(HttpStatusCode.BadRequest)
            call.respond ("Something went wrong ${e.printStackTrace()}".toResponseAsFailure())
        }
    }
}

private fun String.toResponseAsFailure() : ResponseDto {
    return ResponseDto(
        success = false,
        message = this,
    )
}