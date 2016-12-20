/// Created by BB on 2016-12-20.
package com.greenfoxacademy.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private int id;
    private String title;
    private boolean isUrgent;
    private boolean isDone;

    public Todo(int id, String title, boolean isUrgent, boolean isDone) {
        this.id = id;
        this.title = title;
        this.isUrgent = isUrgent;
        this.isDone = isDone;
    }

    public Todo(int id, String title) {
        this.id = id;
        this.title = title;
        this.isUrgent = false;
        this.isDone = false;
    }
}