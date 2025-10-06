package com.example.resource_server.service;

import com.example.resource_server.entity.Product;
import com.example.resource_server.request.AddProductRequest;
import com.example.resource_server.request.UpdateProductRequest;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    /**
     * get all products
     *
     * @return list of products
     */
    List<Product> getAllProduct();

    /**
     * get product by specific product's identity
     *
     * @param productId product's identity
     * @return the product with given identity
     */
    Product getProductById(UUID productId);

    /**
     * Get all products have a given category
     *
     * @param categoryId category's identity
     * @return list of products that have a given category id
     */
    List<Product> getAllProductByCategoryId(Long categoryId);

    /**
     * get all products hava a given sub-category
     *
     * @param subCategoryId sub-category's identity
     * @return list of products that have a given sub-category id
     */
    List<Product> getAllProductBySubCategoryId(Long subCategoryId);
    /**
     * create a new product
     *
     * @param request product's details
     * @return a created product
     */
    Product createProduct(AddProductRequest request);

    /**
     * update product's details
     *
     * @param request product's updated details
     * @param productId product's identity
     * @return an updated product
     */
    Product updateProduct(UpdateProductRequest request, UUID productId);

    /**
     * delete a product by specific identity
     *
     * @param productId product's identity
     */
    void deleteProductById(UUID productId);
}
