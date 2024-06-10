package com.flyway.flyway_example.serviceImpl;

import com.flyway.flyway_example.mapper.Mapper;
import com.flyway.flyway_example.model.Product;
import com.flyway.flyway_example.repository.ProductRepository;
import com.flyway.flyway_example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Override
    public Product addProduct(final Product product) {
        logger.info("addProduct --->");
        logger.info("request payload {}", Mapper.mapJsonToString(product));
        Product addProduct = new Product();
        addProduct.setProductName(product.getProductName());
        addProduct.setDescription(product.getDescription());
        addProduct.setPrice(product.getPrice());
        addProduct.setActive(true);
        logger.info("response payload {}",Mapper.mapJsonToString(addProduct));
        logger.info("<--- addProduct");
        return productRepository.save(addProduct);

    }

    @Override
    public List<Product> getActiveProducts() {
        return productRepository.listAllActiveProducts();
    }

    @Override
    public Product updateproduct(int id, Product product) {
        Product checkProuctIfExists = productRepository.findById(id).orElseThrow(() -> new RuntimeException("id did not found bitch" + id));
        checkProuctIfExists.setProductName(product.getProductName());
        checkProuctIfExists.setDescription(product.getDescription());
        checkProuctIfExists.setPrice(product.getPrice());
        return productRepository.save(checkProuctIfExists);
    }

    @Override
    public String deleteProduct(int id) {
        Product checkProuctIfExists = productRepository.findById(id).orElseThrow(() -> new RuntimeException("id did not found bitch" + id));
        checkProuctIfExists.setActive(false);
        return "deleted bitch";
    }


}
