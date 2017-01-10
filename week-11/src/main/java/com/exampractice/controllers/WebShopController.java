/// Created by BB on 2017-01-10.
package com.exampractice.controllers;

import com.exampractice.services.ShoppingCartItemService;
import com.exampractice.services.WebShopItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebShopController {

    @Autowired
    private WebShopItemService webShopItemService;

    @Autowired
    private ShoppingCartItemService shoppingCartItemService;


    @GetMapping(value="/webshop")
    public String index(Model model,
                        @RequestParam (name="property", defaultValue = "id") String property,
                        @RequestParam (name ="direction", defaultValue = "ASC") String direction) {
        model.addAttribute("webshopitems", webShopItemService.getSortedItems(direction, property));
        model.addAttribute("cartitems", shoppingCartItemService.getItems());
        model.addAttribute("totalprice", shoppingCartItemService.getTotalPrice());
        return "webshop";
    }

    @RequestMapping(value="/sortBy")
    public String sortBy(Model model,
                         @RequestParam (name="property") String property,
                         @RequestParam (name ="direction") String direction)  {
        return "redirect:/webshop?property=" + property + "&direction=" + direction;
    }

    @RequestMapping(value="/addToCart")
    public String addToCart(@RequestParam (name="addToCart") String idString) {

        shoppingCartItemService.addItem(idString, webShopItemService.findOne(idString));
        return "redirect:/webshop";
    }

    @RequestMapping(value="/increment/{increment}/{id}")
    public String increment(@PathVariable("increment") Integer increment,
                            @PathVariable("id") Integer id) {
        shoppingCartItemService.increment(id, increment);
        return "redirect:/webshop";
    }

    @RequestMapping(value="/deleteall/{id}")
    public String deleteAll(@PathVariable("id") Integer id) {
        shoppingCartItemService.deleteAll(id);
        return "redirect:/webshop";
    }
}
