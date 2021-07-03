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
            call.respondText ("Response for the item with the id #$id")
        }

        post("/todos") {
            call.respondText("Hello World! This is Ktor!! ")
        }

        put("/todos/{id}") {
            call.respondText("Hello World! This is Ktor!! ")
        }

        delete("/todos/{id}") {
            call.respondText("Hello World! This is Ktor!! ")
        }
    }

}
