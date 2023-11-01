package com.ashis.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private String name;
    private String description;
    private String timestamp;

    private String status;

    public Todo(String name, String description, String timestamp, String status) {
        this.name = name;
        this.description = description;
        this.timestamp = timestamp;
        this.status = status;
    }

}
