package dev.tbvrln.ecommerce.config;

import dev.tbvrln.ecommerce.model.Order;
import dev.tbvrln.ecommerce.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner orderCommandLineRunner(OrderRepository orderRepository){
        return args -> {
            Order order1 = new Order(
                    LocalDateTime.now().minusDays(2),
                    150.50,
                    null // i should  create and associate a Payment here
            );

            Order order2 = new Order(
                    LocalDateTime.now().minusHours(5),
                    75.20,
                    null // i should  create and associate a Payment here
            );

            orderRepository.saveAll(List.of(order1, order2));
        };
    }
}
