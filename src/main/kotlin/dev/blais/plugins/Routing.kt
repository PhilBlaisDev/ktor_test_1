package dev.blais.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World! This is Ktor!! ")
        }

        get("/todos") {
            call.respondText("Hello World! This is Ktor!! ")
        }

        get("/todos/{id}") {
            val id = call.parameters["id"]
        }

        post("/todos") {

        }

        put("/todos/{id}") {

        }

        delete("/todos/{id}") {

        }
    }

}
