package com.arek.onlinestore.services;

import com.arek.onlinestore.models.Product;
import com.arek.onlinestore.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> update(long id, Product product) {
        return productRepository.findById(id)
                .map(record -> {
                    record.setName(product.getName());
                    record.setPhoto(product.getPhoto());
                    record.setSeries(product.getSeries());
                    record.setPrice(product.getPrice());
                    record.setDiscount(product.getDiscount());
                    productRepository.save(record);
                    return Optional.of(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Product> delete(long id) {
        return productRepository.findById(id)
                .map(record -> {
                    productRepository.delete(record);
                    return Optional.of(record);
                })
                .orElse(Optional.empty());
    }
}
