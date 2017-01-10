/// Created by BB on 2017-01-10.
package com.exampractice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartItem {
    @Id
    private Integer id;
    private String name;
    private Integer price;
    private Integer amount;
    private Integer totalPrice;

    public ShoppingCartItem(WebShopItem webShopItem) {
        this.setId(webShopItem.getId());
        this.setName(webShopItem.getName());
        this.setPrice(webShopItem.getPrice());
        this.amount = 1;
        this.calculateTotalPrice();
    }

    public void incrementAmount(Integer increment) {
        this.amount +=increment;
        this.calculateTotalPrice();
    }

    public void calculateTotalPrice() {
        this.totalPrice = this.getPrice() * this.amount;
    }

}
