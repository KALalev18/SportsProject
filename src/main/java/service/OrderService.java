package service;

import model.Field;
import model.Order;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;
import repository.ProductRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order saveOrder(Order order)
    {
        return orderRepository.save(order);
    }

    public void deleteOrder(Order order)
    {
        orderRepository.delete(order);
    }

    public Order showOrderById(int id)
    {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> showOrders()
    {
        return orderRepository.findAll();
    }

    public Order findByOrder(String order)
    {
        return orderRepository.findByOrder(order);
    }

}
