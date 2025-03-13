package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.exercise.spring_la_mia_pizzeria_crud.entity.Pizza;
import org.exercise.spring_la_mia_pizzeria_crud.repository.PizzaRepository;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
    @Autowired
    private PizzaRepository repo;
   
    @GetMapping 
    public String index(Model model){
        List<Pizza> pizzas = repo.findAll();
        model.addAttribute("pizzas", pizzas);
        return "crud_pages/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") Integer id){
        String index = Integer.toString(id);
        //Pizza pizza = repo.findById(id).get(); da errore vuole uno string
        Pizza pizza = repo.findById(index).get();
        model.addAttribute("pizza", pizza);
        return "crud_pages/show";
    }
}


