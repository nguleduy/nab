package com.example.joseph.productservice.service;

import com.example.joseph.productservice.dto.ProductDTO;

import java.util.List;

public interface ProductService {

  List<ProductDTO> findAll();

  ProductDTO findProductById(Long id);

  ProductDTO add(ProductDTO product);

  ProductDTO update(ProductDTO newProduct);
}
