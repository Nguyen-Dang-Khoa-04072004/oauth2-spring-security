package com.example.resource_server;

import com.example.resource_server.entity.Category;
import com.example.resource_server.entity.Product;
import com.example.resource_server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ResourceServerApplication implements CommandLineRunner {

	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Product> products = List.of(
			Product.builder()
				.productName("Milo")
				.category(Category.BEVERAGE)
				.description("Some description about average")
				.price(20000L)
				.build(),
			Product.builder()
				.productName("KFC chicken")
				.category(Category.FOOD)
				.description("Some description about food")
				.price(34000L)
				.build(),
			Product.builder()
				.productName("Nike")
				.category(Category.SHOES)
				.description("Some description about shoes")
				.price(5000000L)
				.build()
		);
		productRepository.saveAll(products);
	}
}
