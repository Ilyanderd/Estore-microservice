package ru.isands.test.estore.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isands.test.estore.dao.entity.ElectroItem;
import ru.isands.test.estore.service.ElectroItemService;

@Controller
@AllArgsConstructor
public class ElectroItemMvcController {

    private final ElectroItemService service;

    @GetMapping("/electroItems")
    public String electroItem(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<ElectroItem> electroItemsPage = service.getElectroItems(page, size);

        model.addAttribute("electroItems", electroItemsPage);
        model.addAttribute("title", "Электротовары");

        return "electroItem";
    }

    @GetMapping("/electroItems/add")
    public String showAddElectroItem() {
        return "addElectroItem";
    }

    @PostMapping("/electroItems/add")
    public String addElectroItem(@RequestParam String title, @RequestParam long electroType,
                                 @RequestParam long price, @RequestParam long count, @RequestParam String description,
                                 @RequestParam(defaultValue = "false") Boolean inStock) {

        ElectroItem electroItem = new ElectroItem(title, electroType, price, count, inStock, description);

        service.addElectroItem(electroItem);

        return "redirect:/electroItems";
    }
}