package com.example.joseph.cartservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

  List<Item> cart;

  public ShoppingCart(Carts carts) {
    this.cart = carts.getShoppingCart().getCart();
  }
}
