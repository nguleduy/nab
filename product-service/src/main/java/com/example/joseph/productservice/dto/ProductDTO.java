package com.example.joseph.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO extends AbstractDTO {

  private Long id;
  private String name;
  private BigDecimal price;
  private String brand;
  private String colour;

}
