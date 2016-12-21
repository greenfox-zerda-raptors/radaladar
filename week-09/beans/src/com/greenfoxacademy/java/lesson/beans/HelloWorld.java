/// Created by BB on 2016-12-21.
package com.greenfoxacademy.java.lesson.beans;

public class HelloWorld {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    public void getMessage(){
        System.out.println("Your Message (from HelloWorld.java): " + message);
    }
}
