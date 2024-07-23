package co.com.jcgfdev.challenge1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;

    public Long id() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double price() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }
}
