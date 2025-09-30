package com.example.resource_server.service.impl;

import com.example.resource_server.entity.Product;
import com.example.resource_server.exception.ProductNotFoundException;
import com.example.resource_server.repository.ProductRepository;
import com.example.resource_server.request.AddProductRequest;
import com.example.resource_server.request.UpdateProductRequest;
import com.example.resource_server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(null));
    }

    @Override
    public Product createProduct(AddProductRequest request) {
        return productRepository.save(
            Product.builder()
                .productName(request.getProductName())
                .price(request.getPrice())
                .measure(request.getMeasure())
                .description(request.getDescription())
                .productImageUrl(request.getProductImageUrl())
                .build()
        );
    }

    @Override
    public Product updateProduct(UpdateProductRequest request, UUID productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(null));
        Optional.ofNullable(request.getProductName()).ifPresent(name -> product.setProductName(name));
        Optional.ofNullable(request.getPrice()).ifPresent(price -> product.setPrice(price));
        Optional.ofNullable(request.getMeasure()).ifPresent(measure -> product.setMeasure(measure));
        Optional.ofNullable(request.getProductImageUrl()).ifPresent(url -> product.setProductImageUrl(url));
        Optional.ofNullable(request.getDescription()).ifPresent(description -> product.setDescription(description));
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(UUID productId) {
        productRepository.deleteById(productId);
    }
}
