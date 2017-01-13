package com.webshop.domain;/// Created by BB on 2017-01-10.

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebShopItemRepository extends PagingAndSortingRepository<WebShopItem, Integer> {
    public Page<WebShopItem> findAll(Pageable pageable);
    public List<WebShopItem> findAll();
    public long count();
    public WebShopItem findOne(Integer id);
}
