package org.sid.inventoryservice;

import org.springframework.boot.SpringApplication;


import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    //@Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.saveAll(
                    List.of(
                            Product.builder().name("Computer").quantity(12).price(1200.32).build(),
                            Product.builder().name("Phone").quantity(12).price(8000).build(),
                            Product.builder().name("Printer").quantity(12).price(6520.50).build(),
                            Product.builder().name("Laptop").quantity(12).price(12500).build()
                    )
            );
            /*productRepository.saveAll(new Product(null,"ASUS",1100.00,16.00));
            productRepository.save(new Product(null,"HP",4500.50,55.00));
            productRepository.save(new Product(null,"MAC",64300.23,50.00));
            productRepository.save(new Product(null,"ACER",4000.23,75.00));
            productRepository.findAll().forEach(product -> {
                System.out.println(product.toString());
            });*/
        };
    }
}
