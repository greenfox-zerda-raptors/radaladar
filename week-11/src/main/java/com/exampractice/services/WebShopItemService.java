/// Created by BB on 2017-01-10.
package com.exampractice.services;

import com.exampractice.domain.WebShopItem;
import com.exampractice.domain.WebShopItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WebShopItemService {

    @Autowired
    private WebShopItemRepository webShopItemRepository;

    public List<WebShopItem> getSortedItems(String direction, String property) {
        if (direction.equals("DESC")) {
            return webShopItemRepository.findAll(new Sort(Sort.Direction.DESC, property));
        } else {
            return webShopItemRepository.findAll(new Sort(Sort.Direction.ASC, property));
        }
    }

    public WebShopItem findOne(Integer id) {
        return webShopItemRepository.findOne(id);
    }

    public WebShopItem findOne(String idString) {
        Integer id = Integer.parseInt(idString);
        return webShopItemRepository.findOne(id);
    }

}
