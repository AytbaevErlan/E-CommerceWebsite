package dev.tbvrln.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String method; // e.g., card, PayPal
    private String status; // e.g., PAID, PENDING
    private double amount;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
