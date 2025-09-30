package com.example.resource_server.response;

import com.example.resource_server.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ListProductResponse {
    private int code;
    private String message;
    private List<Product> products;
}
