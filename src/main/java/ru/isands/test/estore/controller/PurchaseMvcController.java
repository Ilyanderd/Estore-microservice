package ru.isands.test.estore.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isands.test.estore.dao.entity.Purchase;
import ru.isands.test.estore.service.PurchaseService;

import java.util.Date;

@Controller
@AllArgsConstructor
public class PurchaseMvcController {

    private final PurchaseService service;

    @GetMapping("/purchases")
    public String purchase(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<Purchase> purchasesPage = service.getPurchases(page, size);

        model.addAttribute("purchases", purchasesPage);
        model.addAttribute("pageObject", purchasesPage);
        model.addAttribute("link", "/purchases");
        model.addAttribute("title", "Покупки");

        return "purchase";
    }

    @GetMapping("/purchases/add")
    public String showAddPurchase() {
        return "addPurchase";
    }

    @PostMapping("/purchases/add")
    public String addPurchase(@RequestParam(defaultValue = "0") long id, @RequestParam long electroId, @RequestParam long employeeId,
                              @RequestParam long shopId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date purchaseDate, @RequestParam long type) {

        Purchase purchase = new Purchase(id, electroId, employeeId, shopId, purchaseDate, type);

        service.addPurchase(purchase);

        return "redirect:/purchases";
    }
}
