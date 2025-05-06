package dev.tbvrln.ecommerce.config;

import dev.tbvrln.ecommerce.model.Buyer;
import dev.tbvrln.ecommerce.repository.BuyerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;
@Configuration
public class BuyerConfig {

    @Bean
    CommandLineRunner buyerCommandLineRunner(BuyerRepository buyerRepository) {
        return args -> {
            Buyer buyer1 = new Buyer(
                    "Erlan", "irlan@gmail.com", "123123", "Edwarda Denbwoskiego"
            );

            Buyer buyer2 = new Buyer(
                    "Nurik", "nurik@gmail.com", "222222", "Edwarda Denbwoskiego"
            );

            buyerRepository.saveAll(List.of(buyer1, buyer2));
        };
    }
}
