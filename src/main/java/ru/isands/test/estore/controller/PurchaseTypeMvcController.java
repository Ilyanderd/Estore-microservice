package ru.isands.test.estore.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.service.PurchaseTypeService;

@Controller
@AllArgsConstructor
public class PurchaseTypeMvcController {

    private PurchaseTypeService service;

    @GetMapping("/purchaseTypes")
    public String purchaseType(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<PurchaseType> purchaseTypesPage = service.getPurchaseTypes(page, size);

        model.addAttribute("purchaseTypes", purchaseTypesPage);
        model.addAttribute("title", "Типы покупок");

        return "purchaseType";
    }

    @GetMapping("/purchaseTypes/add")
    public String showAddPurchaseType() {
        return "addPurchaseType";
    }

    @PostMapping("/purchaseTypes/add")
    public String addPurchaseType(@RequestParam(defaultValue = "0") long id,@RequestParam String title) {

        PurchaseType purchaseType = new PurchaseType(id, title);

        service.addPurchaseType(purchaseType);

        return "redirect:/purchaseTypes";
    }
}
