package com.example.joseph.cartservice.repository;

import com.example.joseph.cartservice.model.Carts;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Carts, String> {
}
