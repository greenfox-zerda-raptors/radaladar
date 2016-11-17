package com.greenfox.biczokb.todo;

/**
 * Created by BB on 2016-11-17.
 */

public class ToDoItem {
    private String name;
    private String description = "---";
    private boolean isComplete = false;
    private String startDate = "1";
    private String dueDate = "2";


    /// Constructor ///

    public ToDoItem(String name) {
        this.name = name;
    }

    /// Methods ///

    public void printToDo(){
        final String printFormat ="[ %s ]   %s  \n";
        String c = " ";
        if (isComplete) {
            c ="x";
        }
        System.out.printf(printFormat, c, name);
    }

    /// Getters and Setters ///

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
