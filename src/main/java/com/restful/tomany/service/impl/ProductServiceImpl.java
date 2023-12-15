package com.restful.tomany.service.impl;

import com.restful.tomany.dto.ProductDTO;
import com.restful.tomany.entity.Product;
import com.restful.tomany.mapper.CategoryMapper;
import com.restful.tomany.mapper.ProductMapper;
import com.restful.tomany.repository.CategoryRepository;
import com.restful.tomany.repository.ProductRepository;
import com.restful.tomany.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO insert(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);

        // Mapeia as categorias para CategoryDTO usando o CategoryRepository
        product.setCategories(productDTO.getCategories().stream()
                .map(categoryDTO -> categoryRepository.findById(categoryDTO.getId()).orElse(null))
                .collect(Collectors.toSet()));

        product = productRepository.save(product);

        return productMapper.toDTO(product);
    }
}
