package com.exampractice.domain;/// Created by BB on 2017-01-10.

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartItemRepository extends CrudRepository <ShoppingCartItem, Integer> {
    List<ShoppingCartItem> findAll();
    ShoppingCartItem findOne(Integer id);
    boolean exists(Integer id);
}
