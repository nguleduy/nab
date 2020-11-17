package com.example.joseph.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private String brand;
  private String color;
  private BigDecimal price;
}
