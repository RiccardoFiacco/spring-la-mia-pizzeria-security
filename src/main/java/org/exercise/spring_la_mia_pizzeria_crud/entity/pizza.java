package org.exercise.spring_la_mia_pizzeria_crud.entity;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "pizzas")
public class Pizza implements Serializable{
    @Id
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "url",  nullable = false)
    private String url;
    @Column(name = "price", nullable = false)
    private float price;

    public Pizza(String name, String description, String url, float price) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "pizza: name= " + name + ", description= " + description + ", url= " + url + ", price= " + price + "]";
    }
    
}
