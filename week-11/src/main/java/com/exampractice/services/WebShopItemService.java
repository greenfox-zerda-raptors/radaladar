/// Created by BB on 2017-01-10.
package com.exampractice.services;

import com.exampractice.domain.Session;
import com.exampractice.domain.WebShopItem;
import com.exampractice.domain.WebShopItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebShopItemService {

    @Autowired
    private WebShopItemRepository webShopItemRepository;

    public Page<WebShopItem> getSortedItems(Session session) {
        return webShopItemRepository.findAll(new PageRequest(session.getPage(), session.getLimit(), Sort.Direction.fromString(session.getDirection()), session.getProperty()));
    }

    public ArrayList<Integer> pageCount(Session session) {
        int count = maxPages(session);
        ArrayList<Integer> pages = new ArrayList<>();
        for (int i = 1; i < count+1; i++) {
            pages.add(i);
        }
        return pages;
    }

    public int maxPages(Session session) {
        int count = (int) webShopItemRepository.count() / session.getLimit();
        if(webShopItemRepository.count() % session.getLimit() != 0) {count++;}
        return count;
    }

    public WebShopItem findOne(Integer id) {
        return webShopItemRepository.findOne(id);
    }

    public WebShopItem findOne(String idString) {
        Integer id = Integer.parseInt(idString);
        return webShopItemRepository.findOne(id);
    }
}
