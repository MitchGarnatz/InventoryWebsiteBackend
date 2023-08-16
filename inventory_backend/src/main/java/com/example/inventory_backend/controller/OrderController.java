package com.example.inventory_backend.controller;

import com.example.inventory_backend.model.Order;
import com.example.inventory_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/create")
    public Order create(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable String id) {
        return orderRepository.findById(id);
    }

    @PutMapping("/update")
    public Order update(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        orderRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}