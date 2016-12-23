package com.greenfox.bb.myapp;


/**
 * Created by BB on 2016-12-23.
 */

public class Message {
    private String username;
    private String created_at;
    private String body;

    public Message() {
    }

    public Message(String username, String body) {
        this.username = username;
        this.body = body;
    }

    public String toString(){
        return username +": " + body + " (" + created_at + ")";
    }

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getBody() {
        return body;
    }

    public void setText(String body) {
        this.body = body;
    }
}
