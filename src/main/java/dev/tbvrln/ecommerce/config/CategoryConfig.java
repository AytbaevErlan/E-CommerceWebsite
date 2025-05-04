package dev.tbvrln.ecommerce.config;

import dev.tbvrln.ecommerce.model.Category;
import dev.tbvrln.ecommerce.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CategoryConfig {

    @Bean
    CommandLineRunner categoryCommandLineRunner(CategoryRepository repository){
        return args -> {
            if (!repository.findByName("Electronics Category").isPresent()) {
                Category electronics = new Category("Electronics Category");
                repository.save(electronics);
            }

            if (!repository.findByName("Toys Category").isPresent()) {
                Category toys = new Category("Toys Category");
                repository.save(toys);
            }
        };
    }
}

