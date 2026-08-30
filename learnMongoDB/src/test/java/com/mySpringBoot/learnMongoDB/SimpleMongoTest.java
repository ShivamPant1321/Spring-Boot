package com.mySpringBoot.learnMongoDB;


import com.mySpringBoot.learnMongoDB.entity.Order;
import com.mySpringBoot.learnMongoDB.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class SimpleMongoTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testCreateOrder(){
        Order order = Order.builder()
                .status("READY")
                .quantity(10)
                .totalPrice(100.0)
                .build();

        order = orderRepository.insert(order);

        System.out.println(order);

    }

    @Test
    public void testGetOrder(){
//        List<Order> orderList = orderRepository.findByStatusAndQuantityGreaterThan("READY", 2);


//        List<Order> orderList = orderRepository.findByStatusAndQuantityGreaterThanOrderByCreatedAtDesc("READY", 2);

        List<Order> orderList = orderRepository.findOrdersByStatusAndAbovePrice("READY", 10);
        orderList.forEach(System.out::println);
    }

    @Test
    public void testDeleteOrder(){

        List<Order> orderList = orderRepository.findOrdersByStatusAndAbovePrice("READY", 10);
//        orderList.forEach(System.out::println);
        orderRepository.deleteAll(orderList);
        System.out.println(orderList);
    }

    @Test
    public void pageableTest(){
        Pageable pageable = PageRequest.of(0, 5, Sort.by("totalPrice").descending());

        List<Order> orderList = orderRepository.findAll(pageable).toList();

        orderList.forEach(System.out::println);
    }
}

