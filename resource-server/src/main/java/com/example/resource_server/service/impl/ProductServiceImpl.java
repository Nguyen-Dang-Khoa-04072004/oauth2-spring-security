package com.example.resource_server.service;

import com.example.resource_server.entity.Product;
import com.example.resource_server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    @PreAuthorize("hasAuthority('SCOPE_openid")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
