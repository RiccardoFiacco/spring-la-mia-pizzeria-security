package org.exercise.spring_la_mia_pizzeria_crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exercise.spring_la_mia_pizzeria_crud.model.Ingredinti;

public interface IngredientiRepository extends JpaRepository<Ingredinti, Integer> {
    
}
