package dev.tbvrln.ecommerce.config;

import dev.tbvrln.ecommerce.model.Buyer;
import dev.tbvrln.ecommerce.model.Cart;
import dev.tbvrln.ecommerce.repository.CartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CartConfig {

    @Bean
    CommandLineRunner cartCommandLineRunner(CartRepository cartRepository) {
        return args -> {
            Cart cart1 = new Cart(
                    1L, new Buyer("Erlan", "erlan@gmail", "12121212", "Edwarda 1")
            );

            Cart cart2 = new Cart(
                    2L, new Buyer("Irlan", "irlan@gmail", "12121212", "Edwarda 1")
            );

            cartRepository.saveAll(List.of(cart1, cart2));
        };
    }
}
