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
public class ProductHistoryDTO extends AbstractDTO {

  private Long id;
  private Long productId;
  private String name;
  private String brand;
  private String colour;
  private BigDecimal oldPrice;
  private BigDecimal newPrice;

  public ProductHistoryDTO(ProductDTO productDTO, BigDecimal newPrice) {
    this.productId = productDTO.getId();
    this.name = productDTO.getName();
    this.brand = productDTO.getBrand();
    this.colour = productDTO.getColour();
    this.oldPrice = productDTO.getPrice();
    this.newPrice = newPrice;
  }

}
