package com.ashis.todo.service;

import java.util.List;
import java.util.Scanner;
import com.ashis.todo.dao.TodoDB;
import com.ashis.todo.dto.Todo;

public class TodoService {

    private TodoDB todoDB;
    public TodoService(TodoDB todoDB){
        this.todoDB = todoDB;
    }
    void printOptions(){
        System.out.println("Options:");
        System.out.println("1. Add a Todo");
        System.out.println("2. Show the list of current Todos");
        System.out.println("3. Delete Todo");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    void addTodo( java.util.Scanner scanner){
        System.out.println("Enter Todo name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Todo description: ");
        String description = scanner.nextLine();
        System.out.print("Enter expected finish timestamp: ");
        String timestamp = scanner.nextLine();

        this.todoDB.addTodo(name, description, timestamp);
        System.out.println("Todo added successfully.");
        System.out.println();
    }

    void printAllTodos( java.util.Scanner scanner){
        List<Todo> todos = this.todoDB.getAllTodos();
        if (todos.isEmpty()){
            System.out.println("Current Todo List empty. Please add some.");
            System.out.println();
            return;
        }
        System.out.println("::::::Current Todos:::::::");
        System.out.print("| ID ");
        System.out.print("|    Name   ");
        System.out.print("|    Description   ");
        System.out.print("|    Timestamp   ");
        System.out.print("|    Status   ");
        System.out.println();
        int index = 1;
        for (Todo t : todos) {
            System.out.print(String.format("| %s ", index));
            System.out.print(String.format("|   %s   ", t.getName()));
            System.out.print(String.format("|   %s   ", t.getDescription()));
            System.out.print(String.format("|   %s   ", t.getTimestamp()));
            System.out.print(String.format("|   %s   ", t.getStatus()));
            System.out.println();
        }
    }

    void deleteTodo( java.util.Scanner scanner){
        System.out.println("Enter Todo ID");
        int id = scanner.nextInt() - 1;
        if (!this.todoDB.doesIndexExist(id)){
            System.out.println("ID does not exist.");
            System.out.println();
            return;
        }
        this.todoDB.deleteTodo(id);
        System.out.println("Todo deleted successfully.");
        System.out.println();
        return;
    }

    void doActionsForOption(int option, java.util.Scanner scanner){
        System.out.printf("Option selected %s", option);
        System.out.println();
        switch (option) {
            case 1:
                addTodo(scanner);
                return;
            case 2:
                printAllTodos(scanner);
                return;
            case 3:
                printAllTodos(scanner);
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                System.out.println();
        }

    }

    int getIntInput(java.util.Scanner scanner){
        int inp = scanner.nextInt();
        scanner.nextLine();
        return inp;
    }
    public void start(){
        //Initialize list or db for todo
        Scanner scanner = new Scanner(System.in);
        while(true){
            printOptions();
            int choice = getIntInput(scanner);
            doActionsForOption(choice, scanner);
        }
    }
}
