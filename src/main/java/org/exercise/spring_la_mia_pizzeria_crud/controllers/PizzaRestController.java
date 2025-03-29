package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.exercise.spring_la_mia_pizzeria_crud.model.Pizza;
import org.exercise.spring_la_mia_pizzeria_crud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private ResponseEntity<Pizza> show(@PathVariable Integer id){
        Optional<Pizza> pizza = service.findPizzaById(id); //andiamo a dire che puo esistere una pizza e attribuiamo 
        //alla variabile il valore restituito dal metodo del service 
        if (pizza.isEmpty()) { //se la pizza non esiste
            return new ResponseEntity<Pizza>(HttpStatusCode.valueOf(404));//ritorniamo il wrapper che da l'errore 404
        }
        return new ResponseEntity<Pizza>(pizza.get(), HttpStatus.OK); //altrimenti ritprniamo la pizza e lo status 200
    };

    @PostMapping
    public ResponseEntity<Pizza> post(@Valid @RequestBody Pizza entity) { 
       return new ResponseEntity<Pizza>(service.createPizza(entity), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pizza> putMethodName(@PathVariable Integer id, @Valid @RequestBody Pizza entity) {

       if(service.findPizzaById(id).isEmpty()) {
           return new ResponseEntity<Pizza>(HttpStatusCode.valueOf(404));
       }
       entity.setId(id);
       return new ResponseEntity<Pizza>(service.updatePizza(id, entity), HttpStatusCode.valueOf(200));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Pizza> deleteMethodName(@PathVariable Integer id) {
        if(service.findPizzaById(id).isEmpty()) {
            return new ResponseEntity<Pizza>(HttpStatusCode.valueOf(404));
        }
       service.deletePizza(id);//elimina la pizza
       return new ResponseEntity<Pizza>(HttpStatus.OK);
    }
}
