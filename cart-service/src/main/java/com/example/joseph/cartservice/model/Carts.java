package com.example.joseph.cartservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@RedisHash("carts")
@NoArgsConstructor
@AllArgsConstructor
public class Carts {

  @Id
  @Indexed
  private String name;
  private String address;
  private String phone;
  private ShoppingCart shoppingCart;

  public Carts(String name) {
    this.name = name;
  }
}
