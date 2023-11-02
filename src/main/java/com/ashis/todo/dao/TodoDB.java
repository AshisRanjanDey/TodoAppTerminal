package com.ashis.todo.dao;

import com.ashis.todo.dto.Todo;
import java.util.ArrayList;
import java.util.List;

public class TodoDB {

    private List<Todo> todos;
    public TodoDB() {
        this.todos = new ArrayList<>();;
    }

    public void addTodo(String name, String description, String timestamp) {
        Todo todo = new Todo(name, description, timestamp, "todo");
        this.todos.add(todo);
    }

    public List<Todo> getAllTodos() {
        return this.todos;
    }

    public void deleteTodo(int index) {
        this.todos.remove(index);
    }

    public boolean doesIndexExist(int index) {
        return index >= 0 && index < this.todos.size() ;
    }

    public void setStatus(int id, String status) {
        this.todos.get(id).setStatus(status);
    }
}
