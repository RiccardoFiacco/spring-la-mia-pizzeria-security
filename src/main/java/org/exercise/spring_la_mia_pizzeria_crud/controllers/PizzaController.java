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

import org.exercise.spring_la_mia_pizzeria_crud.model.Offerta;
import org.exercise.spring_la_mia_pizzeria_crud.model.Pizza;
import org.exercise.spring_la_mia_pizzeria_crud.repository.OffertaRepository;
import org.exercise.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/pizzas")
public class PizzaController {
    @Autowired
    private PizzaRepository repo;
    @Autowired
    private OffertaRepository offertRepo;

    @GetMapping 
    public String index(@RequestParam(value = "nome", required = false) String nome, Model model){
        
        List<Pizza> pizzas;

        if (nome != null && !nome.isEmpty()) {
            pizzas = repo.findByNameContaining(nome); // Filtra per nome
        } else {
            pizzas = repo.findAll(); // Mostra tutte se non c'è filtro
        }
        
        model.addAttribute("pizzas", pizzas);
        return "pizzas_crud_pages/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") Integer id){
        Pizza pizza = repo.findById(id).get();
        model.addAttribute("pizza", pizza);
        model.addAttribute("offerts", pizza.getOfferts());
        return "pizzas_crud_pages/show";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "pizzas_crud_pages/create";
    }

    @PostMapping("/create")
    public String create(Model model, @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            return "pizzas_crud_pages/create";
        }

        repo.save(formPizza);
        return "redirect:/pizzas";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable Integer id) {
        model.addAttribute("pizza", repo.findById(id).get());
        return "pizzas_crud_pages/update";
    }

    @PostMapping("/update/{id}")
    public String update(Model model, @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "pizzas_crud_pages/update";
        }
        repo.save(formPizza);
        return "redirect:/pizzas";
    }

    @PostMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id) {
        repo.deleteById(id);
        return  "redirect:/pizzas";
    }
    
    @GetMapping("/{id}/offerts")
    public String offerts(Model model,@PathVariable Integer id) {
        Offerta offerta = new Offerta();
        offerta.setPizza(repo.findById(id).get());
        model.addAttribute("offert", offerta);
        return "offerts_crud_pages/offerts_form";
    }
    
}


