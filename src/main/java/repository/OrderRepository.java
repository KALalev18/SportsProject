package repository;

import model.Order;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order getOrderByOrderIdAndAndProductQuantity(int orderId, int productQuantity);

    Order findByOrder(String order);

}
