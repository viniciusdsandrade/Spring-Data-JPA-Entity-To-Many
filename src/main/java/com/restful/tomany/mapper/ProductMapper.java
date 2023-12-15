package com.restful.tomany.mapper;

import com.restful.tomany.dto.ProductDTO;
import com.restful.tomany.entity.Product;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final CategoryMapper categoryMapper;

    public ProductMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }


    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());

        // Mapeia as categorias para CategoryDTO usando o CategoryMapper
        if (product.getCategories() != null) {
            productDTO.setCategories(product.getCategories().stream()
                    .map(categoryMapper::toDTO)
                    .collect(Collectors.toSet()));
        }

        return productDTO;
    }

    public Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        if (productDTO.getCategories() != null) {
            product.setCategories(productDTO.getCategories().stream()
                    .map(categoryMapper::toEntity)
                    .collect(Collectors.toSet()));
        }

        return product;
    }
}
