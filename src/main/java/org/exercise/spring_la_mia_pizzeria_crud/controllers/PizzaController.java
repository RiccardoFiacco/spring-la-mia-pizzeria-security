package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.exercise.spring_la_mia_pizzeria_crud.model.Pizza;
import org.exercise.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.web.bind.annotation.PostMapping;



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


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "crud_pages/create";
    }

    @PostMapping("/create")
    public String postMethodName(Model m, @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult br){
        
        if(br.hasErrors()){
            return "crud_pages/create";
        }

        repo.save(formPizza);
        return "redirect:/pizzas";
    }
}


