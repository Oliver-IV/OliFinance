package dev.compaoli.finance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/menu")
    public String menu() {
        return "/pages/menu.html" ;
    }

    @GetMapping("/menu/gastos")
    public String gastos() {
        return "/pages/gastos.html" ;
    }

}
