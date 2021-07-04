package dev.blais.repository

import dev.blais.entities.Todo
import dev.blais.entities.TodoDraft

interface ToDoRepository {
    fun getAllTodos(): List<Todo>
    fun getTodo(id: Int): Todo?
    fun addTodo(draft: TodoDraft): Todo
    fun removeTodo(id: Int): Boolean
    fun updateTodo(id: Int, draft: TodoDraft): Boolean
}