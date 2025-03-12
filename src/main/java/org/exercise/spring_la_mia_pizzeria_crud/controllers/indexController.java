package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.exercise.spring_la_mia_pizzeria_crud.entity.Pizza;
import org.exercise.spring_la_mia_pizzeria_crud.repository.PizzaRepository;

@Controller
@RequestMapping("/pizzas")
public class indexController {
    @Autowired
    private PizzaRepository repo;
   
    @GetMapping 
    public String home(Model model){
        List<Pizza> pizzas = repo.findAll();
        model.addAttribute("pizzas", pizzas);
        return "crud_pages/index";
    }

}


