/**
 * Created by BB on 2016-11-17.
 */
package com.greenfox.biczokb.todo;
import java.util.ArrayList;

public class ToDoList {
    private ArrayList<ToDoItem> toDoList = new ArrayList<>(1);

    /// Printing out items ///

    public int size() {
        return toDoList.size();
    }

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

    public void viewDescription(int x) {
        if (toDoList.get(x-1).hasDescription()) {
            System.out.printf("%d - ", x);
            toDoList.get(x - 1).printDescription();
        } else {
            System.out.println("This item has no description.");
        }
    }

    /// Editing list, editing items ///

    public void addToDo(ToDoItem todo) {
        this.toDoList.add(todo);
    }

    public void removeToDo(int x) {
        toDoList.remove(x-1);
    }

    public void editToDo(int x, String s, String n) {
        switch (s) {
            case "n":
            case "name":
                toDoList.get(x-1).setName(n);
                System.out.println("Item modified.");
                break;
            case "d":
            case "desc":
            case "description":
                toDoList.get(x-1).setHasDescription(true);
                toDoList.get(x-1).setDescription(n);
                System.out.println("Item modified.");
                break;
          default:
              System.out.println("Please enter a valid command.");
              break;
        }
    }

    public void complete(int x) {
        toDoList.get(x-1).setComplete(true);
    }

    public void swap(int x, int y) {
        ToDoItem temp = toDoList.get(x-1);
        toDoList.set(x-1, toDoList.get(y-1));
        toDoList.set(y-1, temp);
        System.out.printf("Task #%d swapped with task #%d", x, y);
    }

    public void addList(ToDoList list) {
        toDoList.addAll(list.toDoList);
    }

    /// Saving list ///

    public String printSave(int x) {
        String str = "";
        if (toDoList.get(x).isComplete()) {
            str += "1 ";
        } else {
            str +="0 ";
        }
        str += toDoList.get(x).getName();
        if (toDoList.get(x).hasDescription()) {
            str +="///";
            str +=toDoList.get(x).getDescription();
        }
        return str;
    }

}
