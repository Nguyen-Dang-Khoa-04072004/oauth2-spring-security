package com.example.resource_server.controller;

import com.example.resource_server.entity.Product;
import com.example.resource_server.request.AddProductRequest;
import com.example.resource_server.request.UpdateProductRequest;
import com.example.resource_server.response.ListProductResponse;
import com.example.resource_server.response.ProductResponse;
import com.example.resource_server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<ListProductResponse> getAllProduct(){
       List<Product> products = productService.getAllProduct();
       return ResponseEntity.ok(
           ListProductResponse.builder()
               .code(200)
               .message("Get all products successfully")
               .products(products)
               .build()
       );
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable UUID productId){
       Product product = productService.getProductById(productId);
       return ResponseEntity.ok(buildSuccessResponse(product,"Get a product successfully",200));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody AddProductRequest request){
        Product product = productService.createProduct(request);
        return ResponseEntity.created(URI.create("http://localhost:8082/api/v1/products/%s"
                .formatted(product.getId().toString())))
            .body(buildSuccessResponse(product,"create a product successfully",201));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody UpdateProductRequest request, @PathVariable UUID productId){
        Product product = productService.updateProduct(request, productId);
        return ResponseEntity.ok(buildSuccessResponse(product,"update a product successfully",200));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID productId){
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

    private ProductResponse buildSuccessResponse(Product product, String message, int code){
            return ProductResponse.builder()
                .code(code)
                .message(message)
                .product(product)
                .build();
    }
}
