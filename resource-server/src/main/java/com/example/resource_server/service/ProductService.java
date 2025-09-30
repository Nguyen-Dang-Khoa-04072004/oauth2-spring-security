package com.example.resource_server.service;

import com.example.resource_server.entity.Product;
import com.example.resource_server.request.AddProductRequest;
import com.example.resource_server.request.UpdateProductRequest;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductById(UUID productId);
    Product createProduct(AddProductRequest request);
    Product updateProduct(UpdateProductRequest request);
    Product deleteProductById(UUID productId);
}
