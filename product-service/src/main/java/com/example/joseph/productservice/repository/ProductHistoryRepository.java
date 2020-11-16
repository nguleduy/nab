package com.example.joseph.productservice.repository;

import com.example.joseph.productservice.entity.ProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long> {

  List<ProductHistory> findAllByProductId(Long productId);
}
