package org.exercise.spring_la_mia_pizzeria_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.exercise.spring_la_mia_pizzeria_crud.model.Ingrediente;

public interface IngredientiRepository extends JpaRepository<Ingrediente, Integer> {
     public List<Ingrediente> findByNameContaining(String str);
}
