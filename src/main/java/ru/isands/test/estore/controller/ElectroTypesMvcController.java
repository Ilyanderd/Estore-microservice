package ru.isands.test.estore.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isands.test.estore.dao.entity.ElectroType;
import ru.isands.test.estore.service.ElectroTypeService;

@Controller
@AllArgsConstructor
public class ElectroTypesMvcController {

    private final ElectroTypeService service;

    @GetMapping("/electroTypes")
    public String electroTypes(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<ElectroType> electroTypesPage = service.getElectroTypes(page, size);

        model.addAttribute("electroTypes", electroTypesPage);
        model.addAttribute("pageObject", electroTypesPage);
        model.addAttribute("link", "/electroTypes");
        model.addAttribute("title", "Типы электроники");

        return "electroType";
    }

    @GetMapping("/electroTypes/add")
    public String showAddElectroType() {
        return "addElectroType";
    }

    @PostMapping("/electroTypes/add")
    public String addElectroType(@RequestParam(defaultValue = "0") long id, @RequestParam String title) {

        ElectroType electroType = new ElectroType(id, title);

        service.addElectroType(electroType);

        return "redirect:/electroTypes";
    }
}
