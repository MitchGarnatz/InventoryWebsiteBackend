package com.example.inventory_backend.controller;

import com.example.inventory_backend.model.Cart;
import com.example.inventory_backend.model.Order;
import com.example.inventory_backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/addToCart")
    public Cart create(@RequestBody Cart cart){
        return cartRepository.save(cart);
    }

    @GetMapping("/all")
    public List<Cart> getAllOrders() {
        return cartRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        cartRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        cartRepository.deleteAll();
    }
}