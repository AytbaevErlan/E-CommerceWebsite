package dev.tbvrln.ecommerce.dto;

import lombok.Data;

@Data
public class CartDTO {
    Long id;

    public CartDTO() {
    }

    public CartDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "id=" + id +
                '}';
    }
}
