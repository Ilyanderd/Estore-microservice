package ru.isands.test.estore.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("text", "Home page");
        return "home";
    }
}