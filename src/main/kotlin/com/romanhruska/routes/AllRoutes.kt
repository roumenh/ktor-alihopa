package com.romanhruska.routes

import com.romanhruska.data.FellaController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.insertFella(fellaController: FellaController) {
    post("/fella") {
        val post = call.receive<String>()
        fellaController.insertFella(post)
        call.respondText ("Hello, this is $post from the post body", ContentType.Text.Plain)
    }
}