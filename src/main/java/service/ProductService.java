package service;

import model.Product;
import model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int productId);
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(int productId);
}
