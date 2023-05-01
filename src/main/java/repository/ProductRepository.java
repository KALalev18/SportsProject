package repository;

import model.Product;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductByProductDescription(String productDescription);

    Product findByProduct(String product);
}
