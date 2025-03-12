package org.exercise.spring_la_mia_pizzeria_crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exercise.spring_la_mia_pizzeria_crud.entity.Pizza;

public interface pizzaRepository extends JpaRepository<Pizza, Long> {
} 
