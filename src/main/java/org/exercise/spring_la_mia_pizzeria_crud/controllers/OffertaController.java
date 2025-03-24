package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.exercise.spring_la_mia_pizzeria_crud.repository.OffertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/offerts")
public class OffertaController {

    @Autowired
    private OffertaRepository offertRepository;

    @GetMapping("/create")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
