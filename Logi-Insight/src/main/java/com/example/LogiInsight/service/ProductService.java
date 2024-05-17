package com.example.LogiInsight.service;

import com.example.LogiInsight.exception.NotFoundProductException;
import com.example.LogiInsight.model.dto.ProductDTO;
import com.example.LogiInsight.model.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDTO saveProduct(ProductDTO productDTO);
    Optional<ProductEntity> getById(Long id)throws NotFoundProductException;
    List<ProductDTO> getAllProducts();

}
