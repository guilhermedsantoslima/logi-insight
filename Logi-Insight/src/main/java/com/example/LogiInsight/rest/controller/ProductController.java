package com.example.LogiInsight.rest.controller;

import com.example.LogiInsight.exception.NotFoundProductException;
import com.example.LogiInsight.model.dto.ProductDTO;
import com.example.LogiInsight.model.entity.ProductEntity;
import com.example.LogiInsight.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProductController {
    @Autowired
    private ProductService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO saveProduct(@RequestBody @Valid ProductDTO productDTO){
        return service.saveProduct(productDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductEntity> getById(@PathVariable ("id")Long id)throws NotFoundProductException {
        return service.getById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllProducts(){
        return service.getAllProducts();
    }
}
