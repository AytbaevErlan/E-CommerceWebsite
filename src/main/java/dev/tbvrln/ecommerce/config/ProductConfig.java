package dev.tbvrln.ecommerce.config;

import dev.tbvrln.ecommerce.model.Product;
import dev.tbvrln.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product macBook = new Product(
                    "MackBook", "It is MackBook 13 Air", 4700.01, 200);

            Product iPhone = new Product(
                    "Iphone", "It is iPhone 12", 1700, 200);

            repository.saveAll(List.of(macBook, iPhone));
        };

    }
}
