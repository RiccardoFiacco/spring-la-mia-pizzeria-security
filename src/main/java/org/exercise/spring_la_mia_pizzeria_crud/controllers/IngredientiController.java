package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.exercise.spring_la_mia_pizzeria_crud.repository.IngredientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/ingredients")
public class IngredientiController {
    @Autowired
    private IngredientiRepository ingredientiRepository;

    @GetMapping
    public String Index(Model model){
        model.addAttribute("ingredients", ingredientiRepository.findAll());
        return "ingredienti_crud_pages/index";
    }
}
