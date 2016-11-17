package com.greenfox.biczokb.todo;
import java.util.ArrayList;

/**
 * Created by BB on 2016-11-17.
 */

public class ToDoList {
    private String userName;
    private ArrayList<ToDoItem> toDoList = new ArrayList<>(1);

    public void printList() {
        if (toDoList.size() == 0) {
            System.out.println("No tasks");
        } else {
            int counter = 1;
            System.out.println("");
            for (ToDoItem todo : toDoList) {
                System.out.printf("%d - ", counter);
                todo.printToDo();
                counter++;
            }
        }
    }

    public String printSave(int x) {
        String str = "";
        if (toDoList.get(x).isComplete()) {
            str += "1 ";
        } else {
            str +="0 ";
        }
         str += toDoList.get(x).getName();
        return str;
    }

    public void addToDo(ToDoItem todo) {
        this.toDoList.add(todo);
    }

    public void removeToDo(int x) {
        toDoList.remove(x-1);
    }

    public void editToDo(int x, String s, String n) {
        switch (s) {
            case "name":
                toDoList.get(x-1).setName(n);
                break;
            case "description":
                toDoList.get(x-1).setDescription(n);
                break;
            case "start":
                toDoList.get(x-1).setStartDate(n);
                break;
            case "due":
                toDoList.get(x-1).setDueDate(n);
                break;
//          default:
                /// exception vagy újrapróbálkozás vagy valami
        }
    }

    public void complete(int x) {
        toDoList.get(x-1).setComplete(true);
    }

    public int size() {
        return toDoList.size();
    }
}
