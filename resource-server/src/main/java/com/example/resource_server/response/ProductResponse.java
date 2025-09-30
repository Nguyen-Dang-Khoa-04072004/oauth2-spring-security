package com.example.resource_server.response;

import com.example.resource_server.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Builder
@Data
public class ProductResponse {
    private int code;
    private String message;
    private Product product;
}
