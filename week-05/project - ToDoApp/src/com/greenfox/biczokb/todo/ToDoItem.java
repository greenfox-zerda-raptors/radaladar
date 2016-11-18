/**
 * Created by BB on 2016-11-17.
 */
package com.greenfox.biczokb.todo;

public class ToDoItem {
    private String name;
    private boolean isComplete = false;
    private boolean hasDescription = false;
    private String description = "";

    /// Constructors ///

    public ToDoItem(String name) {
        this.name = name;
    }

    public ToDoItem(String name, String description) {
        this.name = name;
        this.hasDescription = true;
        this.description = description;
    }

    /// Methods ///

    public void printToDo(){
        final String printFormat ="[ %s ]   %s  %s\n";
        String c = " ";
        String d = "";
        if (this.isComplete) {
            c ="x";
        }
        if (this.hasDescription) {
            d = " (...)";
        }
        System.out.printf(printFormat, c, this.name, d);
    }

    public void printDescription() {
        final String printFormat ="[ %s ]   %s -\n\n";
        String c = " ";
        if (this.isComplete) {
            c ="x";
        }
        System.out.printf(printFormat, c, this.name);
        for (String descLine:this.description.split("#")) {
            System.out.println("                    " + descLine);
        }
        System.out.println("");
    }

    /// Getters and Setters ///

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasDescription() {
        return hasDescription;
    }

    public void setHasDescription(boolean hasDescription) {
        this.hasDescription = hasDescription;
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

}
