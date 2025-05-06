package dev.tbvrln.ecommerce.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Table
@Builder
public class Seller {

    @Id
    @SequenceGenerator(name = "seller_sequence",
            sequenceName = "seller_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "seller_sequence")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String shopName;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Product> products;


    public Seller() {
    }

    public Seller(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Seller(String name, String email, String password, String shopName) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.shopName = shopName;
    }

    public Seller(Long id, String name, String email, String password, String shopName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.shopName = shopName;
    }

    public Seller(Long id, String name, String email, String password, String shopName, List<Product> products) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.shopName = shopName;
        this.products = products;
    }

    public Seller(Long id, String name) {
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", shopName='" + shopName + '\'' +
                ", products=" + products +
                '}';
    }
}
