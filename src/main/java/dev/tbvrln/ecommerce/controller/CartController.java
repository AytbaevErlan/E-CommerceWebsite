package dev.tbvrln.ecommerce.controller;



import dev.tbvrln.ecommerce.dto.CartDTO;

import dev.tbvrln.ecommerce.model.Cart;
import dev.tbvrln.ecommerce.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping
    public List<Cart> getCart() {
        return cartService.getCart();
    }


    @PutMapping(path = "{cartId}")
    public void updateCart(@PathVariable("cartId") Long cartId,
                            @RequestBody CartDTO dto) {
        cartService.updateCart(cartId, dto);
    }


    @PostMapping
    public void registerNewCart(@RequestBody CartDTO cartDTO) {
        cartService.createCart(cartDTO);
    }

    @DeleteMapping(path = "{cardId}")
    public void deleteCart(@PathVariable("cardId") Long id) {
        cartService.deleteBuyer(id);
    }
}
