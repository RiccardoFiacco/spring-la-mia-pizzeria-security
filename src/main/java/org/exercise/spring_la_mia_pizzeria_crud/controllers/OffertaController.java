package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import org.exercise.spring_la_mia_pizzeria_crud.repository.OffertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
import org.exercise.spring_la_mia_pizzeria_crud.model.Offerta;

@Controller
@RequestMapping("/offerts")
public class OffertaController {

    @Autowired
    private OffertaRepository offertRepository;
    @PostMapping("/create")
    public String getMethodName(Model model, 
    @Valid @ModelAttribute("offert") Offerta offert, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "offerts_crud_pages/create";
        }
        int id = offert.getPizza().getId();
        offertRepository.save(offert);
        return "redirect:/pizzas/" + id;
    }
    
}
