package org.exercise.spring_la_mia_pizzeria_crud.controllers;
import java.util.List;
import org.exercise.spring_la_mia_pizzeria_crud.model.Ingrediente;
import org.exercise.spring_la_mia_pizzeria_crud.repository.IngredientiRepository;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/ingredients")
public class IngredientiController {
    @Autowired
    private IngredientiRepository ingredientiRepository;

    @GetMapping
    public String Index(Model model, @RequestParam(value = "nome", required = false) String nome){
        Ingrediente ingrediente = new Ingrediente();
        model.addAttribute("ingredient", ingrediente);

        List<Ingrediente> ingredientes;
        if(nome != null && !nome.isEmpty()){
            ingredientes = ingredientiRepository.findByNameContaining(nome);
        } else {
            ingredientes = ingredientiRepository.findAll();
        }
        model.addAttribute("ingredients", ingredientes);
        return "ingredienti_crud_pages/index";
    }

    @PostMapping("/create")
    public String createIng(Model model, @Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "ingredienti_crud_pages/index";
        }
        ingredientiRepository.save(ingrediente);
        return "redirect:/ingredients";
    }

    @GetMapping("/update/{id}")
    public String getFormUpdate(Model model, @PathVariable("id") int id){
        model.addAttribute("ingredient", ingredientiRepository.findById(id).get());
        model.addAttribute("flag", true);
        return "ingredienti_crud_pages/update";
    }

    @PostMapping("/update/{id}")
    public String postMethodName(Model model, @Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "ingredienti_crud_pages/index";
        }
        ingredientiRepository.save(ingrediente);
        return "redirect:/ingredients";
    }
    
}
