package com.example.resource_server;

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
