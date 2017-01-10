/// Created by BB on 2017-01-10.
package com.exampractice.services;

import com.exampractice.domain.ShoppingCartItem;
import com.exampractice.domain.ShoppingCartItemRepository;
import com.exampractice.domain.WebShopItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingCartItemService {

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    public List<ShoppingCartItem> getItems() {
        return shoppingCartItemRepository.findAll();
    }

    public void addItem(String idString, WebShopItem webShopItem) {
        Integer id = Integer.parseInt(idString);
        if (shoppingCartItemRepository.exists(id)) {
            ShoppingCartItem toIncrement = shoppingCartItemRepository.findOne(id);
            toIncrement.incrementAmount(1);
            shoppingCartItemRepository.save(toIncrement);
        } else {
            shoppingCartItemRepository.save(new ShoppingCartItem(webShopItem));
        }
    }

    public void increment(Integer id, Integer increment) {
        ShoppingCartItem toIncrement = shoppingCartItemRepository.findOne(id);
        if (toIncrement.getAmount() == 1 && increment == -1) {
            shoppingCartItemRepository.delete(toIncrement);
        } else {
            toIncrement.incrementAmount(increment);
            shoppingCartItemRepository.save(toIncrement);
        }
    }

    public void deleteAll(Integer id) {
        ShoppingCartItem toDelete = shoppingCartItemRepository.findOne(id);
        shoppingCartItemRepository.delete(toDelete);
    }

    public Integer getTotalPrice(){
        Integer totalprice = 0;
        for (ShoppingCartItem item : getItems()) {
            totalprice += item.getTotalPrice();
        }
        return totalprice;
    }
}
