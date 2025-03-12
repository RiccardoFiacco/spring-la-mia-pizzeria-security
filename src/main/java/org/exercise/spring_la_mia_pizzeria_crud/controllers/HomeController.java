package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/") 
    public String home(Model model){
        return "home";
    }
}
