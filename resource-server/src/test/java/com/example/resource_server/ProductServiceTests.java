package com.example.resource_server;

import com.example.resource_server.entity.Product;
import com.example.resource_server.exception.ProductNotFoundException;
import com.example.resource_server.repository.ProductRepository;
import com.example.resource_server.request.AddProductRequest;
import com.example.resource_server.request.UpdateProductRequest;
import com.example.resource_server.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServiceImpl productService;
    @Test
    void testGetAllProduct(){
        List<Product> mockProducts = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            mockProducts.add(new Product());
        }
        when(productRepository.findAll()).thenReturn(mockProducts);
        List<Product> products = productService.getAllProduct();
        assertThat(products.size()).isEqualTo(5);
        verify(productRepository).findAll();
    }

    @Test
    void testGetProductById_whenProductIsNotNull(){
        Product mockProduct = Product.builder()
            .id(UUID.randomUUID())
            .build();
        when(productRepository.findById(any(UUID.class))).thenReturn(Optional.of(mockProduct));
        Product product = productService.getProductById(mockProduct.getId());
        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo(mockProduct.getId());
        verify(productRepository).findById(any(UUID.class));
    }

    @Test
    void testGetProductById_whenProductIsNull(){
        when(productRepository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThatThrownBy(() -> productService.getProductById(UUID.randomUUID())).isInstanceOf(ProductNotFoundException.class);
        verify(productRepository).findById(any(UUID.class));
    }

    @Test
    void testCreateProduct(){
        AddProductRequest request = mock(AddProductRequest.class);
        when(productRepository.save(any(Product.class))).thenReturn(new Product());
        Product product = productService.createProduct(request);
        assertThat(product).isNotNull();
        verify(productRepository).save(any(Product.class));
    }

    @Test
    void testUpdateProduct_whenProductIsNotNull(){
        final String OLD_PRODUCT_NAME = "Old product name";
        final String NEW_PRODUCT_NAME = "New product Name";
        UpdateProductRequest request = UpdateProductRequest.builder()
            .productName(NEW_PRODUCT_NAME)
            .build();
        Product mockProduct = Product.builder()
            .id(UUID.randomUUID())
            .productName(OLD_PRODUCT_NAME)
            .build();
        when(productRepository.findById(any(UUID.class))).thenReturn(Optional.of(mockProduct));
        mockProduct.setProductName(NEW_PRODUCT_NAME);
        when(productRepository.save(any(Product.class))).thenReturn(mockProduct);
        Product product = productService.updateProduct(request,mockProduct.getId());
        assertThat(product).isNotNull();
        assertThat(product.getProductName()).isNotEqualTo(OLD_PRODUCT_NAME);
        assertThat(product.getProductName()).isEqualTo(NEW_PRODUCT_NAME);
        verify(productRepository).findById(any(UUID.class));
        verify(productRepository).save(any(Product.class));
    }

    @Test
    void testUpdateProduct_whenProductIsNull(){
        final String OLD_PRODUCT_NAME = "Old product name";
        final String NEW_PRODUCT_NAME = "New product Name";
        UpdateProductRequest request = UpdateProductRequest.builder()
            .productName(NEW_PRODUCT_NAME)
            .build();
        when(productRepository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThatThrownBy(() -> productService.updateProduct(request,UUID.randomUUID())).isInstanceOf(ProductNotFoundException.class);
        verify(productRepository).findById(any(UUID.class));
    }

    @Test
    void testDeleteProduct(){
       doNothing().when(productRepository).deleteById(any(UUID.class));
       productService.deleteProductById(UUID.randomUUID());
       verify(productRepository).deleteById(any(UUID.class));
    }
}
