package com.flyway.flyway_example.controller;

import com.flyway.flyway_example.model.Product;
import com.flyway.flyway_example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/home")
    ResponseEntity<String> home(){
        return ResponseEntity.ok("home");
    }

    @PostMapping
    ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try{
            productService.addProduct(product);
            return ResponseEntity.ok(product);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    ResponseEntity<List<Product>> getAllActiveProducts(){
        try {
            List<Product> listProducts = productService.getActiveProducts();
            return ResponseEntity.ok(listProducts);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
        try{
            productService.updateproduct(id, product);
            return ResponseEntity.ok(product);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable int id){
        try{
            productService.deleteProduct(id);
            return ResponseEntity.ok("deleted");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


}
