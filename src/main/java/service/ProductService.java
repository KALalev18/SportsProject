package service;

import model.Product;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import repository.UserRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product)
    {
        productRepository.delete(product);
    }

    public Product showProductById(int id)
    {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> showProducts()
    {
        return productRepository.findAll();
    }

}
