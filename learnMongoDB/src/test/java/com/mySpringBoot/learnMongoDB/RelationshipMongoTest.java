package com.mySpringBoot.learnMongoDB;

import com.mySpringBoot.learnMongoDB.entity.Address;
import com.mySpringBoot.learnMongoDB.entity.Order;
import com.mySpringBoot.learnMongoDB.entity.Products;
import com.mySpringBoot.learnMongoDB.repository.OrderRepository;
import com.mySpringBoot.learnMongoDB.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class RelationshipMongoTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

     @Test
    public void testOrderCreation(){

         Products laptop = Products.builder()
                 .name("Gaming Laptop")
                 .category("Electronics")
                 .price(1200.99)
                 .build();

         laptop = productRepository.save(laptop);

         Products phone = Products.builder()
                 .name("Smart Phone")
                 .category("Electronics")
                 .price(899.99)
                 .build();

         phone = productRepository.save(phone);

         Order order = Order.builder()
                 .status("READY")
                 .quantity(10)
                 .totalPrice(100.0)
                 .address(Address.builder()
                         .line1("Line 1 Address")
                         .city("Ludhiana")
                         .state("Punjab")
                         .build())
                 .products(List.of(laptop, phone))
                 .build();

         order = orderRepository.insert(order);
         System.out.println(order);
     }

     @Test
    public void testOrderFetch(){
//         var orders = orderRepository.findByAddressCity("Ludhiana");
         var orders = orderRepository.findByCity("Ludhiana");

         orders.forEach(System.out::println);
     }

}
