package com.example.joseph.productservice.service;

import com.example.joseph.productservice.entity.Product;
import com.example.joseph.productservice.entity.ProductHistory;
import com.example.joseph.productservice.repository.ProductHistoryRepository;
import com.example.joseph.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductHistoryRepository productHistoryRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findProductById(Long id) {
    return productRepository.findById(id).orElseThrow();
  }

  public Product add(Product product) {
    return productRepository.save(product);
  }

  public Product update(Product newProduct) {
    Product oldProduct = productRepository.findById(newProduct.getId()).orElseThrow();
    if (newProduct.getPrice().compareTo(oldProduct.getPrice()) != 0) {
      ProductHistory productHistory = new ProductHistory(oldProduct, newProduct.getPrice());
      productHistoryRepository.save(productHistory);
    }
    return productRepository.save(newProduct);
  }

}
