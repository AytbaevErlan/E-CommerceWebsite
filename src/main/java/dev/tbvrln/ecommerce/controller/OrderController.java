package dev.tbvrln.ecommerce.controller;

import dev.tbvrln.ecommerce.model.Order;

import dev.tbvrln.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrder();
    }

    @GetMapping(path = "{orderId}")
    public Optional<Order> getOrder(@PathVariable("orderId") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public void registerNewOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
    }

    @PutMapping(path = "{orderId}")
    public void updateTotalAmount(@PathVariable("orderId") Long orderId,
                                  @RequestParam double totalAmount) {
        orderService.updateTotalAmount(orderId, totalAmount);
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
    }

}
