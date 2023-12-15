package com.restful.tomany.entity;

import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Category")
@Table(name = "tb_category",
        schema = "db_to_many")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Category that = (Category) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.products, that.products);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.id == null) ? 0 : id.hashCode());
        hash *= prime + ((this.name == null) ? 0 : name.hashCode());
        for (Product product : this.products) {
            hash *= prime + ((product == null) ? 0 : product.hashCode());
        }

        if (hash < 0)
            hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"name\": \"" + this.name + "\",\n" +
                "  \"products\": " + this.products +
                "\n}";
    }
}