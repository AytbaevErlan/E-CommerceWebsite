package dev.tbvrln.ecommerce.config;


import dev.tbvrln.ecommerce.model.Seller;
import dev.tbvrln.ecommerce.repository.SellerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SellerConfig {
    @Bean
    CommandLineRunner sellerCommandLineRunner(SellerRepository sellerRepository) {
        return args -> {
            Seller seller1 = new Seller(
                    "Erlan", "erlan@gmail.com", "11112222", "The Best Shoes store"
            );

            Seller seller2 = new Seller(
                     "Irlan", "irlan@gmail.com", "22223333", "kid's clothes store"
            );

            sellerRepository.saveAll(List.of(seller1, seller2));

        };


    }
}