package com.example.joseph.productservice.service;

import com.example.joseph.productservice.dto.ProductDTO;
import com.example.joseph.productservice.dto.ProductHistoryDTO;
import com.example.joseph.productservice.entity.Product;
import com.example.joseph.productservice.mapper.ProductHistoryMapper;
import com.example.joseph.productservice.mapper.ProductMapper;
import com.example.joseph.productservice.repository.ProductHistoryRepository;
import com.example.joseph.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductHistoryRepository productHistoryRepository;

  public List<ProductDTO> findAll() {
    List<Product> products = productRepository.findAll();
    return products.stream().map(item -> ProductMapper.INSTANCE.toDto(item)).collect(Collectors.toList());
  }

  public ProductDTO findProductById(Long id) {
    return ProductMapper.INSTANCE.toDto(productRepository.findById(id).orElseThrow());
  }

  public ProductDTO add(ProductDTO product) {
    return ProductMapper.INSTANCE.toDto(productRepository.save(ProductMapper.INSTANCE.toEntity(product)));
  }

  public ProductDTO update(ProductDTO newProduct) {
    Product oldProduct = productRepository.findById(newProduct.getId()).orElseThrow();
    if (newProduct.getPrice().compareTo(oldProduct.getPrice()) != 0) {
      ProductHistoryDTO productHistory = new ProductHistoryDTO(ProductMapper.INSTANCE.toDto(oldProduct), newProduct.getPrice());
      productHistoryRepository.save(ProductHistoryMapper.INSTANCE.toEntity(productHistory));
    }
    return ProductMapper.INSTANCE.toDto(productRepository.save(ProductMapper.INSTANCE.toEntity(newProduct)));
  }

}
