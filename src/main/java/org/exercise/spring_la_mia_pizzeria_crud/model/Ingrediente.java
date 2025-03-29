package org.exercise.spring_la_mia_pizzeria_crud.model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ingredients")
public class Ingrediente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "il campo deve essere popolato")
    @Size(min=5)
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    @JsonBackReference("pizza-ingrediente")
    private List<Pizza> pizzas;

    public Ingrediente() {
    }

    public Ingrediente(int id, @NotBlank(message = "il campo deve essere popolato") @Size(min = 5) String name,
            List<Pizza> pizzas) {
        this.id = id;
        this.name = name;
        this.pizzas = pizzas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public String toString() {
        return "Ingredinti [id=" + id + ", name=" + name + "]";
    }    

}
