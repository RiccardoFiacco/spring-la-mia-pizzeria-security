package org.exercise.spring_la_mia_pizzeria_crud.service;
import java.util.List;
import java.util.Optional;
import org.exercise.spring_la_mia_pizzeria_crud.model.Offerta;
import org.exercise.spring_la_mia_pizzeria_crud.model.Pizza;
import org.exercise.spring_la_mia_pizzeria_crud.repository.OffertaRepository;
import org.exercise.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private OffertaRepository offertaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public List<Pizza> getPizzasByName(String name) {
        return pizzaRepository.findByNameContaining(name);
    }

    public Pizza getPizzaById(Integer id) {
        Optional<Pizza> pizza=  pizzaRepository.findById(id); 
        if(pizza.isEmpty()){
             // o lanciare un'eccezione
        } 
        return pizza.get(); 
    }
    
    public Optional<Pizza> findPizzaById(Integer id) {
        return pizzaRepository.findById(id); 
    }

    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(Integer id, Pizza pizza) {
        if (pizzaRepository.existsById(id)) {
            pizza.setId(id);
            return pizzaRepository.save(pizza);
        } else {
            // o lanciare un'eccezione
            return null;
        }
    }

    public void deletePizza(Integer id) {
        if (pizzaRepository.existsById(id)) {

            for(Offerta offert : pizzaRepository.findById(id).get().getOfferts()){
                offertaRepository.delete(offert);
            }
            pizzaRepository.deleteById(id);
        } else {
            // o lanciare un'eccezione
        }
    }
}
