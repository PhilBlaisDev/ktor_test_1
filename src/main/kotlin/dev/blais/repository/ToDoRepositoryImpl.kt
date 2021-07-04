package dev.blais.repository

import dev.blais.entities.Todo
import dev.blais.entities.TodoDraft

class ToDoRepositoryImpl: ToDoRepository {
    val todos = mutableListOf<Todo>()
//        Todo(1, "Watch Ktor Video 1", true),
//        Todo(2, "Watch Ktor Video 2", false),
//        Todo(3, "Watch Ktor Video 3", false),
//        Todo(4, "Watch Ktor Video 4", false),
//        Todo(5, "Watch Ktor Video 5", false),
//        Todo(6, "Watch Ktor Video 6", false)
//    )

    override fun getAllTodos(): List<Todo> {
        return todos
    }

    override fun getTodo(id: Int): Todo? {
        return todos.firstOrNull { it.id == id }
    }

    override fun addTodo(draft: TodoDraft): Todo {
        val todo = Todo(id = todos.size + 1, title = draft.title, done = draft.done)
        todos.add(todo)
        return todo
    }

    override fun removeTodo(id: Int): Boolean {
            return todos.removeIf { it.id == id }
    }

    override fun updateTodo(id: Int, draft: TodoDraft): Boolean {
        val todo = todos.firstOrNull { it.id == id } ?: return false

        todo.title = draft.title
        todo.done = draft.done
        return true
    }
}