package dev.tbvrln.ecommerce.dto;

import lombok.Data;

@Data
public class SellerDTO {
    private Long id;
    private String name;

    public SellerDTO(Long id, String name) {
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

    @Override
    public String toString() {
        return "SellerDTO" +
                "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}