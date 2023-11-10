package com.ashis.todo.dao;

import com.ashis.todo.dto.Todo;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import com.ashis.todo.config.*;

public class TodoDB {

    private List<Todo> todos;
    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    public TodoDB() {
        System.out.println( "Starting DB" );
        objectMapper = new ObjectMapper();
        try {
            File file = new File(configDb.JSON_FILE);
            if (file.length() == 0) {
                this.todos = new ArrayList<>();
                System.out.println("No existing Data ");
            } else {
                this.todos = objectMapper.readValue(file, new TypeReference<List<Todo>>() {});

                // Data loaded
                System.out.println("Data loaded from JSON: " + this.todos);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
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

    public void saveData(){
        try {
            // Write to a file
            this.objectMapper.writeValue(new File(configDb.JSON_FILE), this.todos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
