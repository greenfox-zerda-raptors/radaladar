package com.greenfox.bb.myapp;


/**
 * Created by BB on 2016-12-23.
 */

public class Message {
    private String name;
    private String time;
    private String text;

    public Message(String name, String time, String text) {
        this.name = name;
        this.time = time;
        this.text = text;
    }

    public String toString(){
        return name +": " + text + " (" + time + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
