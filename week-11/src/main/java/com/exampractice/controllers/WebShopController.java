/// Created by BB on 2017-01-10.
package com.exampractice.controllers;

import com.exampractice.domain.Session;
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

    @Autowired
    private Session session;

    @GetMapping(value="/webshop")
    public String index(Model model){
        model.addAttribute("webshopitems", webShopItemService.getSortedItems(session));
        model.addAttribute("pagecount",webShopItemService.pageCount(session));
        model.addAttribute("cartitems", shoppingCartItemService.getItems());
        model.addAttribute("totalprice", shoppingCartItemService.getTotalPrice());
        return "webshop";
    }

    @RequestMapping(value="/sortBy")
    public String sortBy(Model model,
                         @RequestParam (name="property") String property,
                         @RequestParam (name ="direction") String direction)  {
        session.setPage(0);
        session.setProperty(property);
        session.setDirection(direction);
        return "redirect:/webshop";
    }

    @RequestMapping(value="/itemsPerPage")
    public String itemsPerPage(Model model,
                         @RequestParam (name="limit") int limit) {
        session.setPage(0);
        session.setLimit(limit);
        return "redirect:/webshop";
    }

    @RequestMapping(value="/page/{page}")
    public String page(@PathVariable int page){
        session.setPage(page-1);
        return "redirect:/webshop";
    }

    @RequestMapping(value="/turnOne/{page}")
    public String turnOne(@PathVariable int page){
        if ((session.getPage() != 0 && page == -1) || (session.getPage() != webShopItemService.maxPages(session)-1 && page == 1)) {
            session.setPage(session.getPage()+page);
        }
        return "redirect:/webshop";
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
