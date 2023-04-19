package com.example.sportsproject;

import model.Product;
import model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import repository.ProductRepository;
import view.SportsProjectApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= SportsProjectApplication.class)
public class ProductTesting {
    private ProductRepository productRepository;
    @Test
    public void testProduct(){
        Product product = new Product();
        product.getProductName("Topka");
        product.getProductPrice("19.99");
        product.getProductDescription("Krugla forma");
        productRepository.save(product);
    }
}
