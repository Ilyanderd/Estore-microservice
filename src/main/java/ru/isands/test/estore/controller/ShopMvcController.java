package ru.isands.test.estore.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.service.ShopService;

@Controller
@AllArgsConstructor
public class ShopMvcController {

    private final ShopService service;

    @GetMapping("/shops")
    public String shop(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<Shop> shopPage = service.getShops(page, size);

        model.addAttribute("shops", shopPage);
        model.addAttribute("pageObject", shopPage);
        model.addAttribute("link", "/shops");
        model.addAttribute("title", "Магазины");

        return "shop";
    }

    @GetMapping("/shops/add")
    public String showAddShop() {
        return "addShop";
    }

    @PostMapping("/shops/add")
    public String addShop(@RequestParam(defaultValue = "0") long id, @RequestParam String title, @RequestParam String address) {

        Shop shop = new Shop(id, title, address);

        service.addShop(shop);

        return "redirect:/shops";
    }
}
