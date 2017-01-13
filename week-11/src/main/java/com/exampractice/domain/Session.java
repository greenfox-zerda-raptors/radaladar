/// Created by BB on 2017-01-13.
package com.exampractice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    private int page = 0;
    private int limit = 10;
    private String direction = "ASC";
    private String property = "id";
}
