package com.exampractice.domain;/// Created by BB on 2017-01-10.

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebShopItemRepository extends CrudRepository<WebShopItem, Integer> {
    List<WebShopItem> findAll(Sort sort);
    WebShopItem findOne(Integer id);
}
