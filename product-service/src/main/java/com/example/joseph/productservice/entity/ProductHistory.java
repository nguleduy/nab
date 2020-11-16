package com.example.joseph.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductHistory extends AbstractAuditEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "product_id", nullable = false)
  private Long productId;

  @Column(name = "name")
  private String name;

  @Column(name = "brand")
  private String brand;

  @Column(name = "colour")
  private String colour;

  @Column(name = "old_price")
  private BigDecimal oldPrice;

  @Column(name = "new_price")
  private BigDecimal newPrice;

  public ProductHistory(Product product, BigDecimal newPrice) {
    this.productId = product.getId();
    this.name = product.getName();
    this.brand = product.getBrand();
    this.colour = product.getColour();
    this.oldPrice = product.getPrice();
    this.newPrice = newPrice;
  }
}
