package ru.isands.test.estore.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.isands.test.estore.dao.entity.*;
import ru.isands.test.estore.service.*;

@Controller
@AllArgsConstructor
public class MainController {

    private final ElectroItemService electroItemService;
    private final PurchaseService purchaseService;
    private final EmployeeService employeeService;
    private final PositionTypeService positionTypeService;
    private final ElectroTypeService electroTypeService;
    private final ShopService shopService;
    private final PurchaseTypeService purchaseTypeService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("text", "Home page");
        return "home";
    }

    @GetMapping("/electroItems")
    public String electroItem(Model model) {
        Iterable<ElectroItem> electroItems = electroItemService.getElectroItems();

        model.addAttribute("electroItems", electroItems);
        model.addAttribute("title", "Электротовары");

        return "electroItem";
    }

    @GetMapping("/purchases")
    public String purchase(Model model) {
        Iterable<Purchase> purchases = purchaseService.getPurchases();

        model.addAttribute("purchases", purchases);
        model.addAttribute("title", "Покупки");

        return "purchase";
    }

    @GetMapping("/employees")
    public String employee(Model model) {
        Iterable<Employee> employees = employeeService.getEmployees();

        model.addAttribute("employees", employees);
        model.addAttribute("title", "Сотрудники");

        return "employee";
    }

    @GetMapping("/positions")
    public String position(Model model) {
        Iterable<PositionType> positions = positionTypeService.getPositionTypes();

        model.addAttribute("positions", positions);
        model.addAttribute("title", "Должности");

        return "position";
    }

    @GetMapping("/electroTypes")
    public String electroTypes(Model model) {
        Iterable<ElectroType> electroTypes = electroTypeService.getElectroTypes();

        model.addAttribute("electroTypes", electroTypes);
        model.addAttribute("title", "Типы электроники");

        return "electroType";
    }

    @GetMapping("/shops")
    public String shop(Model model) {
        Iterable<Shop> shop = shopService.getShops();

        model.addAttribute("shop", shop);
        model.addAttribute("title", "Магазины");

        return "shop";
    }

    @GetMapping("/purchaseTypes")
    public String purchaseType(Model model) {
        Iterable<PurchaseType> purchaseTypes = purchaseTypeService.getPurchaseTypes();

        model.addAttribute("purchaseTypes", purchaseTypes);
        model.addAttribute("title", "Типы покупок");

        return "purchaseType";
    }
}