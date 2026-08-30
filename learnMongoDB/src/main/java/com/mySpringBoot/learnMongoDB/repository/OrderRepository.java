package com.mySpringBoot.learnMongoDB.repository;

import com.mySpringBoot.learnMongoDB.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByStatusAndQuantityGreaterThan(String status, Integer quantity);

    List<Order> findByStatusAndQuantityGreaterThanOrderByCreatedAtDesc(String status, Integer quantity);

    @Query("{ 'status': ?0, 'totalPrice': { $gte: ?1 } }")
    List<Order> findOrdersByStatusAndAbovePrice(String status, double minPrice);
}
