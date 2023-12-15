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
@Entity(name = "Product")
@Table(name = "tb_product",
        schema = "db_to_many")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"),
            schema = "db_to_many")
    private Set<Category> categories = new HashSet<>();

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return Objects.equals(this.id, product.id) &&
                Objects.equals(this.name, product.name) &&
                Objects.equals(this.price, product.price) &&
                Objects.equals(this.categories, product.categories);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.id == null) ? 0 : this.id.hashCode());
        hash *= prime + ((this.name == null) ? 0 : this.name.hashCode());
        hash *= prime + ((this.price == null) ? 0 : this.price.hashCode());
        for (Category category : this.categories) {
            hash *= prime + ((category == null) ? 0 : category.hashCode());
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
                "  \"price\": " + this.price + ",\n" +
                "  \"categories\": " + this.categories +
                "\n}";
    }
}