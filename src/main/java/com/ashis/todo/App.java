package com.ashis.todo;

import com.ashis.todo.service.TodoService;
import com.ashis.todo.dao.TodoDB;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Starting App" );
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        //initialize DB
        TodoDB todoDB = new TodoDB();
        TodoService todoServ = new TodoService(todoDB);
        todoServ.start();
    }
}
