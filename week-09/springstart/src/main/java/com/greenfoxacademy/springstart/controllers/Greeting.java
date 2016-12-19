/// Created by BB on 2016-12-19.
package com.greenfoxacademy.springstart.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Greeting {
    @Getter
    private long id;
    @Getter
    private String content;
}
