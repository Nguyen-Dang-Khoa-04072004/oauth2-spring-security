package com.example.resource_server.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateProductRequest {
    private String productName;
    private String productImageUrl;
    private String description;
    private Integer measure;
    private Long price;
}
