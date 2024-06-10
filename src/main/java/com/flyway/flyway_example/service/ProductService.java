package com.flyway.flyway_example.service;

import com.flyway.flyway_example.model.Product;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product addProduct(Product product);
    List<Product> getActiveProducts();
    Product updateproduct(int id, Product product);
    String deleteProduct(int id);
}
