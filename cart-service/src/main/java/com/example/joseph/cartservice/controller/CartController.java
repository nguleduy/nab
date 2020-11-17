package com.example.joseph.cartservice.controller;

import com.example.joseph.cartservice.model.Carts;
import com.example.joseph.cartservice.model.ShoppingCart;
import com.example.joseph.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

  @Autowired
  private CartService cartService;

  @GetMapping("carts")
  public List<Carts> getAll() {
    return cartService.findAll();
  }

  @GetMapping("cart")
  public ShoppingCart getShoppingCartOfCustomer(@RequestHeader("username") String customer) {
    return cartService.findByCustomer(customer);
  }

  @PutMapping("cart")
  public Carts updateShoppingCartOfCustomer(@RequestHeader("username") String customer,
                                            @RequestBody ShoppingCart personalShoppingCart) {
    return cartService.updateShoppingCart(customer, personalShoppingCart);
  }

  @DeleteMapping("cart")
  public void deleteShoppingCart(@RequestHeader("username") String customer) {
    cartService.deleteShoppingCart(customer);
  }
}
