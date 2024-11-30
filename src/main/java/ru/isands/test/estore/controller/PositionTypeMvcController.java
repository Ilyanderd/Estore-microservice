package ru.isands.test.estore.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isands.test.estore.dao.entity.PositionType;
import ru.isands.test.estore.service.PositionTypeService;

@Controller
@AllArgsConstructor
public class PositionTypeMvcController {

    private final PositionTypeService service;

    @GetMapping("/positionTypes")
    public String positionType(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<PositionType> positionsPage = service.getPositionTypes(page, size);

        model.addAttribute("positions", positionsPage);
        model.addAttribute("title", "Должности");

        return "positionType";
    }

    @GetMapping("/positionTypes/add")
    public String showAddPositionType() {
        return "addPositionType";
    }

    @PostMapping("/positionTypes/add")
    public String addPositionType(@RequestParam(defaultValue = "0") long id, @RequestParam String title) {

        PositionType positionType = new PositionType(id, title);

        service.addPositionType(positionType);

        return "redirect:/positionTypes";
    }
}