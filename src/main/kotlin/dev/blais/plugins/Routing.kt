package dev.blais.plugins

import dev.blais.entities.TodoDraft
import dev.blais.repository.ToDoRepository
import dev.blais.repository.ToDoRepositoryImpl
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {

    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }


    routing {

        val repo: ToDoRepository = ToDoRepositoryImpl()

        get("/") {
            call.respondText("Hello World! This is Ktor!! ")
        }

        get("/todos") {
            call.respond(repo.getAllTodos())
        }

        get("/todos/{id}") {
            call.parameters["id"]?.toIntOrNull()?.let { id ->
                repo.getTodo(id)?.let { todo ->
                    call.respond(todo)
                } ?: run {
                    call.respond(HttpStatusCode.NotFound, "No Todos found")
                }
            } ?: run {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }
        }

        post("/todos") {
            val todoDraft = call.receive<TodoDraft>()
            repo.addTodo(todoDraft).let { todo ->
                call.respond(todo)
            }
        }

        put("/todos/{id}") {
            val todoDraft = call.receive<TodoDraft>()
            call.parameters["id"]?.toIntOrNull()?.let{ todoId ->
                repo.updateTodo(todoId, todoDraft).let {
                    if (it){
                        call.respond(HttpStatusCode.OK)
                    } else {
                        call.respond(HttpStatusCode.NotFound, "No Todos found with this id")
                    }
                }
            } ?: run {
                call.respond(HttpStatusCode.BadRequest, "id paramter has to be a number!")
                return@put
            }
        }

        delete("/todos/{id}") {
            call.parameters["id"]?.toIntOrNull()?.let { todoId ->
                repo.removeTodo(todoId).let {
                    if (it){
                        call.respond(HttpStatusCode.OK)
                    } else {
                        call.respond(HttpStatusCode.NotFound, "No Todos found with this id")
                    }
                }
            } ?: run {
                call.respond(HttpStatusCode.BadRequest, "id paramter has to be a number!")
                return@delete
            }
        }
    }

}
