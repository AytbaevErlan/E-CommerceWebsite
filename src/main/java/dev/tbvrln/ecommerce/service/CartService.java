package dev.tbvrln.ecommerce.service;


import dev.tbvrln.ecommerce.dto.CartDTO;
import dev.tbvrln.ecommerce.mapper.CartMapper;
import dev.tbvrln.ecommerce.model.Cart;
import dev.tbvrln.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CartService {
    private final CartRepository cartRepository;


    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public List<Cart> getCart() {
        return cartRepository.findAll();
    }


    public CartDTO createCart(CartDTO dto) {
        Cart saved = cartRepository.save(CartMapper.toEntity(dto));
        return CartMapper.toDTO(saved);
    }

    public CartDTO updateCart(Long id, CartDTO dto) {
        Cart existing = cartRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setId(dto.getId()); // should work on that for adding Product and CartItem
        return CartMapper.toDTO(cartRepository.save(existing));

    }

    public void deleteBuyer(Long id) {
        cartRepository.deleteById(id);
    }

}
