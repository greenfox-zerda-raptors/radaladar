/// Created by BB on 2016-12-21.
package com.greenfoxacademy.caloriecounter.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Meal {
    private String date;
    private String type;
    private String description;
    private int calories;
}
