package dev.tbvrln.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table
public class Buyer {

    @Id
    @SequenceGenerator(name = "buyer_sequence",
            sequenceName = "buyer_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "buyer_sequence")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    // Optional: buyer can have one cart
    @OneToOne(mappedBy = "buyer", cascade = CascadeType.ALL)
    private Cart cart;

    public Buyer() {
    }

    public Buyer(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Buyer(String name, String email, String password, String address, Cart cart) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cart = cart;
    }

    public Buyer(Long id, String name, String email, String password, String address, Cart cart) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cart = cart;
    }

    public Buyer(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", cart=" + cart +
                '}';
    }
}
