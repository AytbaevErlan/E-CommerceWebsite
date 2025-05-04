package dev.tbvrln.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_sequence")
    private Long id;

    private LocalDateTime orderDate;

    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {
    }
    public Order(LocalDateTime orderDate, double totalAmount, Payment payment) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.payment = payment;
    }

    public Order(Long id, LocalDateTime orderDate, double totalAmount, Payment payment) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.payment = payment;
    }



    public Order(Long id, LocalDateTime orderDate, double totalAmount, Buyer buyer, List<OrderItem> orderItems, Payment payment) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.buyer = buyer;
        this.orderItems = orderItems;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", buyer=" + buyer +
                ", orderItems=" + orderItems +
                ", payment=" + payment +
                '}';
    }
}

