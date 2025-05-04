package dev.tbvrln.ecommerce.service;

import dev.tbvrln.ecommerce.model.Order;
import dev.tbvrln.ecommerce.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public void addNewOrder(Order order) {
        Optional<Order> orderOptional = orderRepository.findById((order.getId()));
        if (orderOptional.isPresent()) {
            throw new IllegalStateException("order is already exist");
        }
        orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.findById(orderId);
        boolean exist = orderRepository.existsById(orderId);

        if (!exist) {
            throw new IllegalStateException("Order with id" + orderId + " does not exist");

        }

        orderRepository.deleteById(orderId);
    }

    @Transactional
    public void updateTotalAmount(Long orderId, double totalAmount) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order with id " + orderId + " does not exist"));

        if (totalAmount > 0 && !Objects.equals(order.getTotalAmount(), totalAmount)) {
            order.setTotalAmount(totalAmount);
        }
    }


}


