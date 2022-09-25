package com.kazi.store.repo;

import com.kazi.store.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepo extends MongoRepository<Cart, Integer> {
}
