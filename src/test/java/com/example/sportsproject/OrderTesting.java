package com.example.sportsproject;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import repository.OrderRepository;
import view.SportsProjectApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= SportsProjectApplication.class)
public class OrderTesting {
    private OrderRepository orderRepository;
    @Test
    public void testOrder(){
        Order order = new Order();
        order.getProductQuantity(1);
        order.getTotalPrice(19.99);
        orderRepository.save(order);
    }
}
