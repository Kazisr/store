package com.kazi.store.repo;

import com.kazi.store.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdersRepo extends MongoRepository<Orders, Integer> {
}
