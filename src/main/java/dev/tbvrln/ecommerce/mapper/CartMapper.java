package dev.tbvrln.ecommerce.mapper;

import dev.tbvrln.ecommerce.dto.CartDTO;
import dev.tbvrln.ecommerce.model.Cart;
import org.mapstruct.Mapper;

@Mapper
public class CartMapper {
    public static CartDTO toDTO(Cart cart) {
        return new CartDTO(cart.getId());
    }

    public static Cart toEntity(CartDTO dto) {
        return new Cart(dto.getId());
    }
}
