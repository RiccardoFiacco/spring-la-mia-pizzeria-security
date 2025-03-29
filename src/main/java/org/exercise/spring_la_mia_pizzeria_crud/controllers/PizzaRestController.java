package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.exercise.spring_la_mia_pizzeria_crud.model.Pizza;
import org.exercise.spring_la_mia_pizzeria_crud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;








@RestController
@RequestMapping("/api/pizzas")
public class PizzaRestController {
    @Autowired
    private PizzaService service; 

    @GetMapping
    private List<Pizza> index(){
        List<Pizza> pizzas = service.getAllPizzas();
        return pizzas; 
    };

    @GetMapping("/{id}")
    private Pizza show(@PathVariable Integer id){
        Pizza pizza = service.getPizzaById(id);
        return pizza; 
    };

    @PostMapping
    public Pizza post(@RequestBody Pizza entity) {
       return service.createPizza(entity);
    }
    
    @PutMapping("/{id}")
    public Pizza putMethodName(@PathVariable Integer id, @RequestBody Pizza entity) {
       entity.setId(id);
       return service.updatePizza(id, entity);
    }
    
    @DeleteMapping("/{id}")
    public void deleteMethodName(@PathVariable Integer id) {
       service.deletePizza(id);
    }
}
