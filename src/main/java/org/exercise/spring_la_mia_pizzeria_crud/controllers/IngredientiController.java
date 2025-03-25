package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.exercise.spring_la_mia_pizzeria_crud.model.Ingrediente;
import org.exercise.spring_la_mia_pizzeria_crud.repository.IngredientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/ingredients")
public class IngredientiController {
    @Autowired
    private IngredientiRepository ingredientiRepository;

    @GetMapping
    public String Index(Model model){
        Ingrediente ingrediente = new Ingrediente();
        model.addAttribute("ingredients", ingredientiRepository.findAll());
        model.addAttribute("ingredient", ingrediente);
        return "ingredienti_crud_pages/index";
    }

    @PostMapping("/create")
    public String createIng(Model model, @Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "ingredienti_crud_pages/index";
        }
        ingredientiRepository.save(ingrediente);
        return "redirect:/ingredients";
    }
}
