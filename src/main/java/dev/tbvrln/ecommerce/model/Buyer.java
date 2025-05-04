package dev.tbvrln.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    // Optional: buyer can have one cart
    @OneToOne(mappedBy = "buyer", cascade = CascadeType.ALL)
    private Cart cart;
}
