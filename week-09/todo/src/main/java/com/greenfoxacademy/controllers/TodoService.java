/// Created by BB on 2016-12-20.
package com.greenfoxacademy.controllers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {
    private List<Todo> fakeTodoStore = new ArrayList<Todo>(
            Arrays.asList(
                    new Todo(0, "Create an action", true, true),
                    new Todo(1, "Add @RequestMapping to it"),
                    new Todo(2, "Return the viewName from the action")));

    public List<Todo> getTodos() {
        return fakeTodoStore;
    }

    public void addTodo(Todo todo){
        if(todo.getId() == 0){
            todo.setId(fakeTodoStore.size());
        }
        fakeTodoStore.add(todo);
    }
}