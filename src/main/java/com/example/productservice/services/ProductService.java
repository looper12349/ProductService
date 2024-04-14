package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductsById(Long id);
    List<Product> getAllProducts();
}
