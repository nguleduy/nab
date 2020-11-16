package com.example.joseph.productservice.service;

import com.example.joseph.productservice.entity.Product;

import java.util.List;

public interface ProductService {

  List<Product> findAll();

  Product findProductById(Long id);

  Product add(Product product);

  Product update(Product newProduct);
}
