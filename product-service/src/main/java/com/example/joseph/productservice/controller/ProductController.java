package com.example.joseph.productservice.controller;

import com.example.joseph.productservice.constants.Constant;
import com.example.joseph.productservice.dto.ProductDTO;
import com.example.joseph.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constant.PRODUCT_URL)
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<ProductDTO> getAllProducts() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public ProductDTO getProductDetail(@PathVariable String id) {
    return productService.findProductById(Long.parseLong(id));
  }

  @PutMapping("/{id}")
  public ProductDTO updateProduct(@Valid @RequestBody ProductDTO product, @PathVariable String id) {
    product.setId(Long.parseLong(id));
    return productService.update(product);
  }

  @PostMapping
  public ProductDTO addProduct(@Valid @RequestBody ProductDTO product) {
    return productService.add(product);
  }
}
