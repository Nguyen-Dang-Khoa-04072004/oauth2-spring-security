package com.example.resource_server.controller;

import com.example.resource_server.entity.Product;
import com.example.resource_server.response.ListProductResponse;
import com.example.resource_server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<ListProductResponse> getAllProduct(Authentication authentication){
       var jwt = (Jwt) authentication.getPrincipal();
       final String username = jwt.getClaim("username");
       List<Product> products = productService.getAllProduct();
       return ResponseEntity.ok(
           ListProductResponse.builder()
               .code(200)
               .message("User: %s Get all products successfully".formatted(username))
               .products(products)
               .build()
       );
    }
}
