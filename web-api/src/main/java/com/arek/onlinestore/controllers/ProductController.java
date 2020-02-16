package com.arek.onlinestore.controllers;

import com.arek.onlinestore.consts.ApiConst;
import com.arek.onlinestore.models.Product;
import com.arek.onlinestore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping({ApiConst.PRODUCTS_URL})
public class ProductController {
    final ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return productService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable long id,
                                          @RequestBody Product product) {
        return productService.update(id, product)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return productService.delete(id)
                .map(record -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.notFound().build());
    }
}
