package com.restful.tomany.dto;

import com.restful.tomany.entity.Category;
import lombok.Getter;

import java.util.Objects;

@Getter
public class CategoryDTO {
    private Long id;
    private String name;

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        CategoryDTO that = (CategoryDTO) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.id == null) ? 0 : this.id.hashCode());
        hash *= prime + ((this.name == null) ? 0 : this.name.hashCode());

        if (hash < 0)
            hash *= (-1);

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"name\": \"" + this.name + "\"\n" +
                "}";
    }
}