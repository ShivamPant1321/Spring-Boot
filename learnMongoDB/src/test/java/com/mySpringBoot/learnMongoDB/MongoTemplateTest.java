package com.mySpringBoot.learnMongoDB;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void mongoTemplate(){
//        List<Order> orderList = mongoTemplate.findAll(Order.class);

//        Query query = new Query(
//                Criteria.where("status").in("READY", "pending").and("totalPrice").gt(120)
//        );


        Query query = new Query(
                new Criteria().orOperator(
                        Criteria.where("totalPrice").lte(120),
                        Criteria.where("status").is("pending")
                )
        );

        query.fields().include("status", "id");

        query.limit(2);
        List<Order> orderList = mongoTemplate.find(query, Order.class);


        orderList.forEach(System.out::println);
    }

    @Test
    public void mongoTemplateUpdateTest(){
        Query query = new Query(
                Criteria.where("status").is("READY")
        );

        Update update = new Update().set("status", "SHIPPED").set("updatedAt", new Date());

        mongoTemplate.updateMulti(query, update, Order.class);
    }
}
