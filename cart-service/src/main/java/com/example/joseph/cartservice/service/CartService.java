package com.example.joseph.cartservice.service;

import com.example.joseph.cartservice.model.Carts;
import com.example.joseph.cartservice.model.ShoppingCart;
import com.example.joseph.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

  @Autowired
  private CartRepository cartRepository;

  public List<Carts> findAll() {
    ArrayList<Carts> result = new ArrayList<>();
    Iterable<Carts> shoppingCarts = cartRepository.findAll();
    shoppingCarts.forEach(result::add);
    return result;
  }

  public ShoppingCart findByCustomer(String customer) {
    Carts shoppingCart = cartRepository.findById(customer).orElseThrow();
    return new ShoppingCart(shoppingCart);
  }

  public Carts updateShoppingCart(String customer, ShoppingCart personalShoppingCart) {
    Optional<Carts> shoppingCart = cartRepository.findById(customer);
    Carts customerShoppingCart = shoppingCart.orElse(new Carts(customer));
    customerShoppingCart.setShoppingCart(personalShoppingCart);
    return cartRepository.save(customerShoppingCart);
  }

  public void deleteShoppingCart(String customer) {
    cartRepository.deleteById(customer);
  }
}
