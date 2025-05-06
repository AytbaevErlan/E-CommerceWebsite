package dev.tbvrln.ecommerce.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Table
@Builder
public class Cart {

    @Id
    @SequenceGenerator(name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(Long id) {
        this.id = id;
    }

    public Cart(Long id, Buyer buyer) {
        this.id = id;
        this.buyer = buyer;
    }

    public Cart(Long id, Buyer buyer, List<CartItem> cartItems) {
        this.id = id;
        this.buyer = buyer;
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", cartItems=" + cartItems +
                '}';
    }
}
