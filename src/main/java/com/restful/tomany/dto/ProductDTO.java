package com.restful.tomany.dto;

import com.restful.tomany.entity.Category;
import com.restful.tomany.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        for (Category category : product.getCategories()) {
            this.categories.add(new CategoryDTO(category));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;


        ProductDTO that = (ProductDTO) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.price, that.price) &&
                Objects.equals(this.categories, that.categories);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.id == null) ? 0 : this.id.hashCode());
        hash *= prime + ((this.name == null) ? 0 : this.name.hashCode());
        hash *= prime + ((this.price == null) ? 0 : this.price.hashCode());
        for (CategoryDTO category : this.categories) {
            hash *= prime + ((category == null) ? 0 : category.hashCode());
        }

        if (hash < 0)
            hash *= (-1);

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"price\": " + price + ",\n" +
                "  \"categories\": " + categories +
                "\n}";
    }
}