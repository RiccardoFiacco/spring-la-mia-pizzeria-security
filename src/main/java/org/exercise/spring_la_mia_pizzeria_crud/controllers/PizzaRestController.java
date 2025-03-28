package org.exercise.spring_la_mia_pizzeria_crud.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.exercise.spring_la_mia_pizzeria_crud.model.Pizza;
import org.exercise.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/pizza")
public class PizzaRestController {
    @Autowired
    private PizzaService service; 

    private List<Pizza> index(){
        return repo.findAll(); // Mostra tutte se non c'è filtro
    };
}
