package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String index(@RequestParam(value = "nome", required = false) String nome, Model model){
        
        List<Pizza> pizzas;

        if (nome != null && !nome.isEmpty()) {
            pizzas = repo.findByNameContaining(nome); // Filtra per nome
        } else {
            pizzas = repo.findAll(); // Mostra tutte se non c'è filtro
        }
        
        model.addAttribute("pizzas", pizzas);
        return "crud_pages/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") Integer id){
        Pizza pizza = repo.findById(id).get();
        model.addAttribute("pizza", pizza);
        return "crud_pages/show";
    }
}


