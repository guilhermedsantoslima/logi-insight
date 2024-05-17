package com.example.LogiInsight.service.impl;

import com.example.LogiInsight.exception.NotFoundProductException;
import com.example.LogiInsight.model.dto.ProductDTO;
import com.example.LogiInsight.model.entity.ProductEntity;
import com.example.LogiInsight.repository.ProductRepository;
import com.example.LogiInsight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setNomeProduto(productDTO.getNomeProduto());
        productEntity.setQuantidade(productDTO.getQuantidade());

        productRepository.save(productEntity);

        return productDTO;
    }

    @Override
    public Optional<ProductEntity> getById(Long id)throws NotFoundProductException {
        Optional<ProductEntity> product = productRepository.findById(id);

        if(!product.isPresent()){
            throw new NotFoundProductException();
        }

        return productRepository.findById(id);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        productEntities.forEach(p ->{
            ProductDTO productDTO = new ProductDTO();

            productDTO.setNomeProduto(p.getNomeProduto());
            productDTO.setQuantidade(p.getQuantidade());

            productDTOS.add(productDTO);
        });

        return productDTOS;
    }
}
