package com.mySpringBoot.learnMongoDB.repository;

import com.mySpringBoot.learnMongoDB.entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products, String> {

}
