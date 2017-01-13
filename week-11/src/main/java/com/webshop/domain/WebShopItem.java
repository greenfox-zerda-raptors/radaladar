/// Created by BB on 2017-01-10.
package com.webshop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebShopItem {
    @Id
    private Integer id;
    private String name;
    private String description;
    private Integer price;
}

